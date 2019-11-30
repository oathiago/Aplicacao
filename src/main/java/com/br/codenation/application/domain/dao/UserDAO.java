package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);
}
