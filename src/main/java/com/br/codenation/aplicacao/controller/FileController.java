package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.impl.FileServiceImpl;

public class FileController {

    private static final String PATH = "C:\\Users\\Thiago\\Desktop";
    private static final String EMPRESA = "\\empresa.txt";
    private static final String USUARIOS = "\\usuarios.txt";

    private FileServiceImpl fileService = new FileServiceImpl();

    public void leituraDeArquivo() {
        fileService.reader(PATH, EMPRESA);
        fileService.reader(PATH, USUARIOS);
    }
}
