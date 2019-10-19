package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.entity.Usuario;
import com.br.codenation.aplicacao.service.AplicacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTest {

	AplicacaoService aplicacaoService = new AplicacaoService();

	@Test
	void testUsuario(){
		Usuario usuario = aplicacaoService.createUsuario(1L, "Teste Thiago", "123456987",
				20, "testeThiago", "123456");
		assert (usuario != null);
		assert (usuario.getNome().equals("Teste Thiago"));
	}

}
