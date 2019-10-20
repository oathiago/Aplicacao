package com.br.codenation.aplicacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario extends Pessoa{

    private String login;
    private String senha;
    private Empresa empresa;

    public Usuario() {}

    public Usuario(Long id, String nome, String documento,
    int idade, String login, String senha, Empresa empresa) {
        this.setId(id);
        this.setNome(nome);
        this.setDocumento(documento);
        this.setIdade(idade);
        this.login = login;
        this.senha = senha;
        this.empresa = empresa;
    }

}
