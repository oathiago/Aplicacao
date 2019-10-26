package com.br.codenation.aplicacao.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Company extends Person {

    private int vacancies;
    private List<User> userList;
    private String site;

    public Company(Long id, String name, String document, int vacancies, String site) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.vacancies = vacancies;
        userList = new ArrayList<>();
        this.site = site;
    }
}
