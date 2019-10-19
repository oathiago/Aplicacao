package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.AplicacaoService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpresaController {

    AplicacaoService aplicacaoService = new AplicacaoService();

    public void createEmpresa(Long id, String nome, String documento,
                              int vagas) {
        aplicacaoService.createEmpresa(id, nome, documento, vagas);
    }

}
