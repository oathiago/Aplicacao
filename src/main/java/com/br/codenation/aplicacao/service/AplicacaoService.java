package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.entity.Empresa;
import com.br.codenation.aplicacao.entity.Usuario;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AplicacaoService {

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    List<Usuario> usuarioList = new ArrayList<>();
    List<Empresa> empresaList = new ArrayList<>();

    public Usuario createUsuario(Long id,
                                 String nome,
                                 String documento,
                                 int idade,
                                 String login,
                                 String senha) {

        Usuario usuario = new Usuario(id, nome, documento, idade, login, senha);
        usuarioList.add(usuario);
        LOG.info("#### INCLUSAO DE USUARIO {} FEITA COM SUCESSO!", usuario.getNome());
        return usuario;
    }

    public void createEmpresa(Long id, String nome, String documento, int vagas) {

        if (empresaList.stream().filter(empresa -> empresa.getDocumento().equals(documento)).findFirst().isPresent()) {
            LOG.error("#### ERROR - JA EXISTE UMA EMPRESA COM ESTE DOCUMENTO!");
        } else if (empresaList.stream().filter(empresa -> empresa.getNome().equals(nome)).findFirst().isPresent()){
            LOG.error("#### ERROR - JA EXISTE UMA EMPRESA COM ESTE NOME!");
        } else {
            Empresa empresa = new Empresa(id, nome, documento, vagas);
            empresaList.add(empresa);
            LOG.info("#### INCLUSAO DE EMPRESA {} FEITA COM SUCESSO!", empresa.getNome());
        }


    }
}
