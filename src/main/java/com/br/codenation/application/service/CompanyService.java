package com.br.codenation.application.service;

import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.domain.vo.CompanyVO;

import java.util.List;

public interface CompanyService {

    CompanyVO createCompany(CompanyVO companyVO);

    void deleteCompany(Company company);

    List<CompanyVO> findAllCompanies();

    Long countCompanies();
}
