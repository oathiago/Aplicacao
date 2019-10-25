package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.impl.ApplicationServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class UserController {

    private ApplicationServiceImpl applicationService = new ApplicationServiceImpl();

    public void createUser(String name,
                           String document,
                           int age,
                           String login,
                           String password,
                           Long idCompany,
                           BigDecimal salary) {

        applicationService.createUser(name, document, age, login, password, idCompany, salary);

    }
}
