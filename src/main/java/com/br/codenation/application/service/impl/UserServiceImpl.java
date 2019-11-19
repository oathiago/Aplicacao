package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.UserDAO;
import com.br.codenation.application.domain.entity.User;
import com.br.codenation.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }


}
