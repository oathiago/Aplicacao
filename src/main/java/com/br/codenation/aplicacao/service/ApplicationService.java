package com.br.codenation.aplicacao.service;


import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;

import java.math.BigDecimal;

public interface ApplicationService {

    User createUser(String nome, String documento, int idade,
                    String login, String senha, Long idEmpresa,
                    BigDecimal salary);

    Company createCompany(String nome, String documento, int vagas);


    Company findCompanyById(Long idEmpresa);

    void addUserInCompany(Company empresa, User usuario);
}
