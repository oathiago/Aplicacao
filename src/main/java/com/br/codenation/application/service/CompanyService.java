package com.br.codenation.application.service;

import com.br.codenation.application.domain.entity.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(String name, String document, int vacancies, String site);

    List<Company> findAllByIdOrNameContainsOrDocument(Long id, String name, String document);
}
