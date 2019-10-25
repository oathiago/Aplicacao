package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;
import com.br.codenation.aplicacao.service.impl.ApplicationServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ApplicationTest {

    ApplicationServiceImpl aplicacaoService = new ApplicationServiceImpl();

    @Test
    @Ignore
    void testCreateUser() {
        Company empresa = aplicacaoService.createCompany("Empresa Teste", "15494851515156", 1);
        User usuario = aplicacaoService.createUser("Teste Thiago", "123456987",
                20, "testeThiago", "123456", empresa.getId(),
                new BigDecimal(4324.03));
        assert (usuario != null);
        assert (usuario.getName().equals("Teste Thiago"));
    }

    @Test
    @Ignore
    void validateDuplicateCompany() {
        try {
            aplicacaoService.createCompany("Empresa Teste2", "1543421515156", 1);
            aplicacaoService.createCompany("Empresa Teste2", "1543421515156", 1);
        } catch (Exception e) {
            assert (e.getClass().getName().contains("Codenation"));
        }
    }

}
