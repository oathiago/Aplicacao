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
    CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity createCompany(@RequestBody CompanyVO companyVO) {
        return ResponseEntity.ok(companyService.createCompany(companyVO));
    }

    @GetMapping("/findAll")
    public ResponseEntity getCompanies(){
        return ResponseEntity.ok(companyService.findAllCompanies());
    }
}
