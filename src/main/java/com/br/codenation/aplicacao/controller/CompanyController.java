package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.impl.ApplicationServiceImpl;

public class CompanyController {

    private ApplicationServiceImpl applicationService = new ApplicationServiceImpl();

    public void createCompany(String name, String document,
                              int vacancies, String site) {
        applicationService.createCompany(name, document, vacancies, site);
    }

}
