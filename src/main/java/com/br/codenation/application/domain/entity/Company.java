package com.br.codenation.application.domain.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
