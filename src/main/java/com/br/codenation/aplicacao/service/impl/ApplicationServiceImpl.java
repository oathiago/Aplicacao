package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;
import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.ApplicationService;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class ApplicationServiceImpl extends BaseService implements ApplicationService {

    @Override
    public User createUser(String name,
                           String document,
                           int age,
                           String login,
                           String password,
                           Long idCompany,
                           BigDecimal salary) {

        validateUserRequiredFields(name, document, login, password);
        validateUser(name, document, login);

        Company company = findCompanyById(idCompany);
        if (company == null) {
            throw new CodenationException("#### ERROR - EMPRESA NÃO ENCONTRADA!");
        }
        Long id = (long) (userList.size() + 1);
        User user = new User(id, name, document, age, login, password, company, salary);
        userList.add(user);
        LOG.info("#### INCLUSÃO DE USUÁRIO {}, DOCUMENTO {}, IDADE {} FEITA COM SUCESSO!", user.getName(), user.getDocument(), user.getAge());
        addUserInCompany(company, user);
        return user;

    }

    private void validateUserRequiredFields(String name, String document, String login, String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(document) || StringUtils.isEmpty(login)
                || StringUtils.isEmpty(password)) {
            throw new CodenationException("#### ERROR - PREENCHA OS CAMPOS OBRIGATÓRIOS!");
        }
    }

    private void validateUser(String name, String document, String login) {
        if (userList.stream().anyMatch(user -> user.getName().equals(name)
                || user.getLogin().equals(login)
                || user.getDocument().equals(document))) {
            throw new CodenationException("#### ERROR - USUÁRIO JÁ CADASTRADO ANTERIORMENTE!");
        }
    }

    @Override
    public Company createCompany(String name, String coeument, int vacancies) {

        validateCompany(name, coeument);
        Long id = (long) (empresaList.size() + 1);
        Company empresa = new Company(id, name, coeument, vacancies);
        empresaList.add(empresa);
        LOG.info("#### INCLUSÃO DE EMPRESA {} FEITA COM SUCESSO!", empresa.getName());
        return empresa;

    }

    private void validateCompany(String name, String document) {
        if (empresaList.stream().anyMatch(company -> company.getDocument().equals(document))) {
            throw new CodenationException("#### ERROR - JÁ EXISTE UMA EMPRESA COM ESTE DOCUMENTO!");
        } else if (empresaList.stream().anyMatch(company -> company.getName().equals(name))) {
            throw new CodenationException("#### ERROR - JÁ EXISTE UMA EMPRESA COM ESTE NOME!");
        }
    }

    @Override
    public Company findCompanyById(Long idEmpresa) {
        return empresaList.stream().filter(empresa -> empresa.getId().equals(idEmpresa)).findFirst().orElse(null);
    }

    @Override
    public void addUserInCompany(Company empresa, User usuario) {
        for (Company company : empresaList) {
            if (company.getId().equals(empresa.getId())) {
                company.getUserList().add(usuario);
            }
        }
    }
}
