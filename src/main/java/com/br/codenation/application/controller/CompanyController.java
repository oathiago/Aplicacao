package com.br.codenation.application.controller;

import com.br.codenation.application.domain.vo.CompanyVO;
import com.br.codenation.application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PutMapping("/create")
    public ResponseEntity createCompany(@RequestBody CompanyVO companyVO) {
        companyService.createCompany(companyVO.getName(), companyVO.getDocument(),
                companyVO.getVacancies(), companyVO.getSite());
        return ResponseEntity.ok().build();
    }

}