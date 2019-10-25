package com.br.codenation.aplicacao.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User extends Person {

    private String login;
    private String password;
    private Company company;
    private BigDecimal salary;

    public User(Long id, String name, String document,
                int age, String login, String password, Company company,
                BigDecimal salary) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.setAge(age);
        this.login = login;
        this.password = password;
        this.company = company;
        this.salary = salary;
    }

}
