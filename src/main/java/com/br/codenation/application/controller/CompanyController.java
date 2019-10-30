package com.br.codenation.application.controller;

import com.br.codenation.application.domain.vo.CompanyVO;
import com.br.codenation.application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PutMapping("/create")
    public ResponseEntity createCompany(@RequestBody CompanyVO companyVO) {
        return ResponseEntity.ok(companyService.createCompany(companyVO.getName(), companyVO.getDocument(),
                companyVO.getVacancies(), companyVO.getSite()));
    }

    @GetMapping
    public ResponseEntity findCompanies(@RequestBody CompanyVO companyVO) {
        return ResponseEntity.ok(companyService.findAllByIdOrNameContainsOrDocument(companyVO.getId(),
                companyVO.getName(), companyVO.getDocument()));
    }

}
