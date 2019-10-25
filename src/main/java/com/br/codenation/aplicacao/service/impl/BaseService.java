package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class BaseService {

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    static List<User> userList = new ArrayList<>();
    static List<Company> empresaList = new ArrayList<>();
}
