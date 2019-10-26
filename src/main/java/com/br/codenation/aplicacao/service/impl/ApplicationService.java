package com.br.codenation.aplicacao.service.impl;


import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;

import java.math.BigDecimal;

public interface ApplicationService {

    User createUser(String name, String document, int age,
                    String login, String password, Long idCompany,
                    BigDecimal salary);

    Company createCompany(String name, String document, int vacancies, String site);


    Company findCompanyById(Long idCompany);

    void addUserInCompany(Company company, User user);
}
