package com.br.codenation.application.domain.entity;

import lombok.Data;

@Data
class Person {

    private Long id;
    private String name;
    private String document;
    private int age;

}
