package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.CompanyDAO;
import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends BaseService implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public Company createCompany(String name, String document, int vacancies, String site) {

        Company company = Company.builder()
                .name(name)
                .document(document)
                .vacancies(vacancies)
                .site(site)
                .build();
        company = companyDAO.save(company);
        LOG.info("#### INCLUSÃO DE EMPRESA {} FEITA COM SUCESSO!", company.getName());
        return company;
    }
}
