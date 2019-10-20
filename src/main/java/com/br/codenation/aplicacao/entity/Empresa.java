package com.br.codenation.aplicacao.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Empresa extends Pessoa {

    private int vagas;
    List<Usuario> usuarioList;

    public Empresa(Long id, String nome, String documento, int vagas){
        this.setId(id);
        this.setNome(nome);
        this.setDocumento(documento);
        this.vagas = vagas;
        usuarioList = new ArrayList<>();
    }
}
