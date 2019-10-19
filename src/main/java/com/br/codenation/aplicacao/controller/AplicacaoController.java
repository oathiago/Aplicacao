package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.AplicacaoService;

public class AplicacaoController {

    AplicacaoService aplicacaoService = new AplicacaoService();

    public void createUsuario(Long id,
                              String nome,
                              String documento,
                              int idade,
                              String login,
                              String senha) {

        aplicacaoService.createUsuario(id, nome, documento, idade, login, senha);

    }
}
