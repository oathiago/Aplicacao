package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.entity.Empresa;
import com.br.codenation.aplicacao.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseService {

    Logger LOG = LoggerFactory.getLogger(BaseService.class);

    static List<Usuario> usuarioList = new ArrayList<>();
    static List<Empresa> empresaList = new ArrayList<>();
}
