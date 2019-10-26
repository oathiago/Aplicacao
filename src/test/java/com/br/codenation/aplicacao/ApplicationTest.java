package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.annotation.Column;
import com.br.codenation.aplicacao.domain.entity.Company;
import com.br.codenation.aplicacao.domain.entity.User;
import com.br.codenation.aplicacao.service.impl.ApplicationServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTest {

    private Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);
    private ApplicationServiceImpl aplicacaoService = new ApplicationServiceImpl();

    @Test
    void testCreateUser() {
        User usuario = createUser();
        assert (usuario != null);
        assert (usuario.getName().equals("Teste Thiago"));
    }

    private User createUser() {
        Company empresa = aplicacaoService.createCompany("Empresa Teste", "15494851515156", 1);
        return aplicacaoService.createUser("Teste Thiago", "123456987",
                20, "testeThiago", "123456", empresa.getId(),
                new BigDecimal(4324.03543));
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

    @Test
    void testReflection() {

        Class<User> myClassUser = User.class;
        for (Field declaredField : myClassUser.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Column.class)) {
                LOG.info(declaredField.getName());
            }
        }

        Class<ApplicationServiceImpl> myClass = ApplicationServiceImpl.class;
        for (Method declaredMethod : myClass.getDeclaredMethods()) {
            LOG.info(declaredMethod.getName());
        }

        List<User> users = new ArrayList<>();
        users.add(createUser());
        users.forEach(user -> {
            for (Field declaredField : user.getClass().getDeclaredFields()) {
                if (declaredField.getAnnotation(Column.class) != null) {
                    switch (declaredField.getAnnotation(Column.class).position()) {
                        case 1:
                            LOG.info(declaredField.getAnnotation(Column.class).text() +
                                    user.getLogin());
                            break;
                        case 2:
                            LOG.info(declaredField.getAnnotation(Column.class).text() +
                                    user.getCompany().getName());
                            break;
                    }
                }
            }
        });

        Field [] fields = myClassUser.getDeclaredFields();
        Method [] methods = myClass.getDeclaredMethods();

        assert (fields.length == 4);
        assert (methods.length == 11);
    }

}
