package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.entity.Company;
import com.br.codenation.application.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
class BaseService {

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    static List<User> userList = new ArrayList<>();
}
