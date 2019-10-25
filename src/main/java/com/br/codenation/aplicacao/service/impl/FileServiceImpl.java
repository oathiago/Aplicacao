package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.FileService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class FileServiceImpl extends BaseService implements FileService {

    private static final String ENCODING = "UTF-8";
    private ApplicationServiceImpl applicationService = new ApplicationServiceImpl();

    @Override
    public void reader(String path, String file) {
        try {
            LOG.info("#### BUSCANDO ARQUIVO {}", path + file);
            File fileDir = new File(path + file);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), ENCODING
                    )
            );

            String linha;
            while ((linha = in.readLine()) != null) {
                String[] arrayLinha = linha.split(";");
                if (file.contains("empresa")) {
                    populateAndCallCreateCompany(arrayLinha);
                } else if (file.contains("usuarios")) {
                    populateAndCallCreateUser(arrayLinha);
                }
            }
            in.close();
        } catch (Exception e) {
            throw new CodenationException(e.getMessage());
        }
    }

    private void populateAndCallCreateCompany(String[] arrayLinha) {
        String nome = arrayLinha[0];
        String documento = arrayLinha[1];
        int vagas = Integer.parseInt(arrayLinha[2]);
        applicationService.createCompany(nome, documento, vagas);
    }

    private void populateAndCallCreateUser(String[] arrayLinha) {
        String nome = arrayLinha[0];
        String documento = arrayLinha[1];
        int idade = Integer.parseInt(arrayLinha[2]);
        String login = arrayLinha[3];
        String senha = arrayLinha[4];
        Long idEmpresa = Long.parseLong(arrayLinha[5]);
        BigDecimal salary = new BigDecimal(arrayLinha[6]);
        applicationService.createUser(nome, documento, idade,
                login, senha, idEmpresa, salary);
    }
}
