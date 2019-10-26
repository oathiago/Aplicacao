package com.br.codenation.aplicacao.domain.entity;

import com.br.codenation.aplicacao.annotation.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User extends Person {

    @Column(position = 1, text = "My login is ")
    private String login;

    private String password;

    @Column(position = 2, text = "My Company is ")
    private Company company;

    @Column(position = 3, text = "My salary is ")
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
