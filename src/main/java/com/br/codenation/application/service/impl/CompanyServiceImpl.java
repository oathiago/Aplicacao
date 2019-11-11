package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.CompanyDAO;
import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional
    public Company createCompany(String name, String document, int vacancies, String site) {

        Company company = Company.builder()
                .name(name)
                .document(document)
                .vacancies(vacancies)
                .site(site)
                .build();

        return companyDAO.save(company);

    }

    @Override
    public void deleteCompany(Company company) {

    }
}
