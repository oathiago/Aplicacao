package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.entity.Empresa;
import com.br.codenation.aplicacao.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AplicacaoService {

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
        System.out.println("#### INCLUSAO DE USUARIO FEITA COM SUCESSO!");
        return usuario;
    }
}
