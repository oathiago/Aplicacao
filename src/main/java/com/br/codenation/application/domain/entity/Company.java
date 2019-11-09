package com.br.codenation.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "count_by_name",
                procedureName = "company.count_by_name",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "name",
                                type = String.class),
                        @StoredProcedureParameter(
                                mode = ParameterMode.OUT,
                                name = "count",
                                type = Long.class)
                }
        )
})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    @NotNull
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "vacancies")
    private int vacancies;

    @Column(name = "site")
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList;

    @Transient
    private String time;
}