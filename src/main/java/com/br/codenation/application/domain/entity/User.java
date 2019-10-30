package com.br.codenation.application.domain.entity;

import com.br.codenation.application.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "age")
    private int age;

    @ColumnAnnotation(position = 1, text = "My login is ")
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ColumnAnnotation(position = 2, text = "My Company is ")
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ColumnAnnotation(position = 3, text = "My salary is ")
    @Column(name = "salary")
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
