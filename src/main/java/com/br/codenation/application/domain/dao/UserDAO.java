package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

}
