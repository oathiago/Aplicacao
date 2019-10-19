package com.br.codenation.aplicacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario extends Pessoa{

    private String login;
    private String senha;

    public Usuario() {}

    public Usuario(Long id, String nome, String documento,
    int idade, String login, String senha) {
        this.setId(id);
        this.setNome(nome);
        this.setDocumento(documento);
        this.setIdade(idade);
        this.login = login;
        this.senha = senha;
    }

}
