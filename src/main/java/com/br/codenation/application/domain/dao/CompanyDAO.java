package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyDAO extends JpaRepository<Company, Long> {

    @Query("SELECT c " +
            "FROM Company " +
            "WHERE c.name like :name " +
            "ORDER BY name")
    List<Company> findCompanies(@Param("name") String name);

    List<Company> findAllByNameOrderByName(@Param("name") String name);

}

