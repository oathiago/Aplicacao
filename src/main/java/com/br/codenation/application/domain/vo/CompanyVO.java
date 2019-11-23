package com.br.codenation.application.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about the CompanyVO. ")
public class CompanyVO {

    private Long id;
    private String name;
    private String document;
    private Integer vacancies;
    private String site;
}
