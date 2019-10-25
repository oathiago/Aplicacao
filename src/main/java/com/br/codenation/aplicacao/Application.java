package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.controller.FileController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//        UsuarioController aplicacaoController = new UsuarioController();
//        EmpresaController empresaController= new EmpresaController();
        FileController arquivoController = new FileController();

        arquivoController.leituraDeArquivo();

//        empresaController.createEmpresa(1L, "Codenation", "21545465561548", 3);
//        empresaController.createEmpresa(2L, "Banco Inter", "21545465561548", 3);
//        empresaController.createEmpresa(2L, "Banco Inter", "54484845465455", 3);

//        aplicacaoController.createUsuario(1L, "Thiago",
//                "123456789", 31, "oathiago",
//                "codenation", 1L);
//        aplicacaoController.createUsuario(2L, "Thor",
//                "45648456", 7, "thor",
//                "codenation", 1L);
//        aplicacaoController.createUsuario(1L, "Thiago",
//                "123456789", 31, "oathiago",
//                "codenation", 1L);
    }


}
