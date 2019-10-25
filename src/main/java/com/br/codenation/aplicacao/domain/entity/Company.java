package com.br.codenation.aplicacao.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Company extends Person {

    private int vacancies;
    List<User> userList;

    public Company(Long id, String name, String document, int vacancies) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.vacancies = vacancies;
        userList = new ArrayList<>();
    }
}
