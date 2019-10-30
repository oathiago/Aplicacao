package com.br.codenation.application.controller;

import com.br.codenation.application.service.impl.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private ApplicationService applicationService;

    public void createCompany(String name, String document,
                              int vacancies, String site) {
        applicationService.createCompany(name, document, vacancies, site);
    }

}
