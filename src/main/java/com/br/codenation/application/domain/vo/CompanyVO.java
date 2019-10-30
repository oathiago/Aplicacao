package com.br.codenation.application.domain.vo;

import lombok.Data;

@Data
public class CompanyVO {

    private Long id;
    private String name;
    private String document;
    private Integer vacancies;
    private String site;
}
