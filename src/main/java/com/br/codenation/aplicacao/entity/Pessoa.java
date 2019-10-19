package com.br.codenation.aplicacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

    private Long id;
    private String nome;
    private String documento;
    private int idade;

}
