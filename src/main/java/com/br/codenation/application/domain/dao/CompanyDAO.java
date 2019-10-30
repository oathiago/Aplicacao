package com.br.codenation.application.domain.dao;

import com.br.codenation.application.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.websocket.server.PathParam;
import java.util.List;

public interface CompanyDAO extends JpaRepository<Company, Long> {

    List<Company> findAllByIdOrNameContainsOrDocument(@PathParam("id") Long id,
                                                      @PathParam("name") String name,
                                                      @PathParam("document") String document);
}
