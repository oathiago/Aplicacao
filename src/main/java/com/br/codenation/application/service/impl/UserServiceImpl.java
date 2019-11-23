package com.br.codenation.application.service.impl;

import com.br.codenation.application.domain.dao.UserDAO;
import com.br.codenation.application.domain.entity.User;
import com.br.codenation.application.domain.vo.UserVO;
import com.br.codenation.application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public User createUser(UserVO userVO) {
        User user = modelMapper.map(userVO, User.class);
        return userDAO.save(user);
    }


}
