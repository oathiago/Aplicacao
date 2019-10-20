package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.AplicacaoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    AplicacaoService aplicacaoService = new AplicacaoService();

    public void createUsuario(Long id,
                              String nome,
                              String documento,
                              int idade,
                              String login,
                              String senha,
                              Long idEmpresa) {

        aplicacaoService.createUsuario(id, nome, documento, idade, login, senha, idEmpresa);

    }
}
