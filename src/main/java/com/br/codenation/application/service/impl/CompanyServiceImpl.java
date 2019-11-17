package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.CompanyDAO;
import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.domain.vo.CompanyVO;
import com.br.codenation.application.service.CompanyService;
import org.modelmapper.ModelMapper;
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

    ModelMapper modelMapper = new ModelMapper();

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    @Override
    @Transactional
    public CompanyVO createCompany(CompanyVO companyVO) {

        Company company = companyDAO.save(modelMapper.map(companyVO, Company.class));
        return modelMapper.map(company, CompanyVO.class);
    }

    @Override
    public void deleteCompany(Company company) {

    }

    @Override
    public List<CompanyVO> findAllCompanies() {
        LOG.info("#### FIND ALL COMPANIES ####");
        return modelMapper.map(companyDAO.findAll(), List.class);
    }

    @Override
    public Long countCompanies() {
        return companyDAO.count();
    }
}
