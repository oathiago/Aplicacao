package com.br.codenation.application.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Company {

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

    @Column(name = "vacancies")
    private int vacancies;

    @Column(name = "site")
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList;

    public Company(Long id, String name, String document, int vacancies, String site) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.vacancies = vacancies;
        userList = new ArrayList<>();
        this.site = site;
    }
}
