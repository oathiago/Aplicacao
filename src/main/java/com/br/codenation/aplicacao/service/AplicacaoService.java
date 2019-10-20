package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.entity.Empresa;
import com.br.codenation.aplicacao.entity.Usuario;
import com.br.codenation.aplicacao.exception.CodenationException;
import org.springframework.util.StringUtils;

public class AplicacaoService extends BaseService {

    public Usuario createUsuario(Long id,
                                 String nome,
                                 String documento,
                                 int idade,
                                 String login,
                                 String senha,
                                 Long idEmpresa) {

        if (StringUtils.isEmpty(nome) || StringUtils.isEmpty(documento) || StringUtils.isEmpty(login)
                || StringUtils.isEmpty(senha)) {
            LOG.error("#### ERROR - PREENCHA OS CAMPOS OBRIGATÓRIOS!");
        } else {

            if (usuarioList.stream().anyMatch(usuario -> usuario.getNome().equals(nome)
                    || usuario.getLogin().equals(login)
                    || usuario.getDocumento().equals(documento))) {
                LOG.error("#### ERROR - USUÁRIO {} JÁ CADASTRADO ANTERIORMENTE!", nome);
            } else {

                Empresa empresa = findEmpresaById(idEmpresa);
                if (empresa == null) {
                    LOG.error("#### ERROR - EMPRESA NÃO ENCONTRADA!");
                } else {
                    Usuario usuario = new Usuario(id, nome, documento, idade, login, senha, empresa);
                    usuarioList.add(usuario);
                    LOG.info("#### INCLUSÃO DE USUÁRIO {}, DOCUMENTO {}, IDADE {} FEITA COM SUCESSO!", usuario.getNome(), usuario.getDocumento(), usuario.getIdade());
                    adicionarUsuarioEmpresa(empresa, usuario);
                    return usuario;
                }
            }
        }
        return null;

    }

    public Empresa createEmpresa(Long id, String nome, String documento, int vagas) {

        if (empresaList.stream().filter(empresa -> empresa.getDocumento().equals(documento)).findFirst().isPresent()) {
            throw new CodenationException("#### ERROR - JÁ EXISTE UMA EMPRESA COM ESTE DOCUMENTO!");
        } else if (empresaList.stream().filter(empresa -> empresa.getNome().equals(nome)).findFirst().isPresent()) {
            throw new CodenationException("#### ERROR - JÁ EXISTE UMA EMPRESA COM ESTE NOME!");
        }
        Empresa empresa = new Empresa(id, nome, documento, vagas);
        empresaList.add(empresa);
        LOG.info("#### INCLUSÃO DE EMPRESA {} FEITA COM SUCESSO!", empresa.getNome());
        return empresa;

    }

    public Empresa findEmpresaById(Long idEmpresa) {
        return empresaList.stream().filter(empresa -> empresa.getId().equals(idEmpresa)).findFirst().orElse(null);
    }

    public void adicionarUsuarioEmpresa(Empresa empresa, Usuario usuario) {
        for (Empresa company : empresaList) {
            if (company.getId().equals(empresa.getId())) {
                company.getUsuarioList().add(usuario);
            }
        }
    }
}
