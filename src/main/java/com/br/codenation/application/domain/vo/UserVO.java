package com.br.codenation.application.domain.vo;

import com.br.codenation.application.domain.entity.Company;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about the UserVO. ")
public class UserVO {

    private Long id;

    private String name;

    private String document;

    private int age;

    private String username;

    private Company company;

    private BigDecimal salary;
}
