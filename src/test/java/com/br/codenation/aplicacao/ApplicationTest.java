package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.entity.Empresa;
import com.br.codenation.aplicacao.entity.Usuario;
import com.br.codenation.aplicacao.service.AplicacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTest {

	AplicacaoService aplicacaoService = new AplicacaoService();

	@Test
	void testCreateUser(){
		Empresa empresa = aplicacaoService.createEmpresa(10L, "Empresa Teste", "15494851515156", 1);
		Usuario usuario = aplicacaoService.createUsuario(1L, "Teste Thiago", "123456987",
				20, "testeThiago", "123456", empresa.getId());
		assert (usuario != null);
		assert (usuario.getNome().equals("Teste Thiago"));
	}

	@Test
	void validateEmpresaRepetida(){
		try {
			aplicacaoService.createEmpresa(20L, "Empresa Teste2", "1543421515156", 1);
			aplicacaoService.createEmpresa(20L, "Empresa Teste2", "1543421515156", 1);
		} catch (Exception e) {
			assert (e.getClass().getName().contains("Codenation"));
		}
	}

}
