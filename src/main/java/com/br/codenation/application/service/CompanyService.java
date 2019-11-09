package com.br.codenation.application.service;

import com.br.codenation.application.domain.entity.Company;

public interface CompanyService {

    Company createCompany(String name, String document, int vacancies, String site);

    void deleteCompany(Company company);
}
