package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.CompanyDAO;
import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.domain.vo.CompanyVO;
import com.br.codenation.application.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    @Override
    @Transactional
    public Company createCompany(CompanyVO companyVO) {

        Company company = Company.builder()
                .name(companyVO.getName())
                .document(companyVO.getDocument())
                .vacancies(companyVO.getVacancies())
                .site(companyVO.getSite())
                .build();

        return companyDAO.save(company);

    }

    @Override
    public void deleteCompany(Company company) {

    }

    @Override
    public List<CompanyVO> findAllCompanies() {
        LOG.info("#### FIND ALL COMPANIES ####");
        List<Company> companyList = companyDAO.findAll();
        List<CompanyVO> companyVOList = companyList.stream().map(company -> {
            return CompanyVO.builder()
                    .id(company.getId())
                    .name(company.getName())
                    .document(company.getDocument())
                    .vacancies(company.getVacancies())
                    .site(company.getSite())
                    .build();
        }).collect(Collectors.toList());
        return companyVOList;
    }

    @Override
    public Long countCompanies() {
        return companyDAO.count();
    }
}
