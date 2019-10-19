package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.controller.UsuarioController;
import com.br.codenation.aplicacao.controller.EmpresaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AplicacaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(AplicacaoApplication.class, args);

        UsuarioController aplicacaoController = new UsuarioController();
        EmpresaController empresaController= new EmpresaController();

        aplicacaoController.createUsuario(1L, "Thiago",
                "123456789", 31, "oathiago",
                "codenation");

        empresaController.createEmpresa(1L, "Codenation", "21545465561548", 3);
    }


}
