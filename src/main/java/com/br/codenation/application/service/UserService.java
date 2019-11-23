package com.br.codenation.application.service;

import com.br.codenation.application.domain.entity.User;
import com.br.codenation.application.domain.vo.UserVO;

public interface UserService {

    User createUser(UserVO user);
}
