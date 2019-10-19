package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.controller.AplicacaoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(AplicacaoApplication.class, args);

        AplicacaoController aplicacaoController = new AplicacaoController();
        aplicacaoController.createUsuario(1L, "Thiago",
                "123456789", 31, "oathiago",
                "codenation");
    }


}
