package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyDAO extends JpaRepository<Company, Long> {

}

