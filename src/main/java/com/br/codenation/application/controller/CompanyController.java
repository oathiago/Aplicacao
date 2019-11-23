package com.br.codenation.application.controller;

import com.br.codenation.application.domain.vo.CompanyVO;
import com.br.codenation.application.service.CompanyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/company")
@Api(value = "Company Controller")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/create")
    @ApiOperation(value = "Method to create a new company in system.", response = CompanyVO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved Company")
    })
    public ResponseEntity createCompany(@ApiParam(value = "Company VO") @Valid @RequestBody CompanyVO companyVO) {
        return ResponseEntity.ok(companyService.createCompany(companyVO));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "Method to find all companies.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    })
    public ResponseEntity getCompanies(){
        return ResponseEntity.ok(companyService.findAllCompanies());
    }
}
