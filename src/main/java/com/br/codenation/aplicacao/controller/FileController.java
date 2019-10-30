package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/file")
public class FileController {

    private static final String PATH = "C:\\Users\\Thiago\\Desktop";
    private static final String EMPRESA = "\\empresa.txt";
    private static final String USUARIOS = "\\usuarios.txt";

    @Autowired
    private FileService fileService;

    @CrossOrigin
    @PutMapping("/reader")
    public ResponseEntity fileReader() {
        fileService.reader(PATH, EMPRESA);
        fileService.reader(PATH, USUARIOS);
        return ResponseEntity.ok().build();
    }
}
