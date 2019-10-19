package com.br.codenation.aplicacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa extends Pessoa {

    private int vagas;

    public Empresa(Long id, String nome, String documento, int vagas){
        this.setId(id);
        this.setNome(nome);
        this.setDocumento(documento);
        this.vagas = vagas;
    }
}
