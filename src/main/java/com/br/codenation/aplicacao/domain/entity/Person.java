package com.br.codenation.aplicacao.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Person {

    private Long id;
    private String name;
    private String document;
    private int age;

}
