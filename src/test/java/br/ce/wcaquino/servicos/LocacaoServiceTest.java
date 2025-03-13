package br.ce.wcaquino.servicos;


import static org.junit.Assert.*;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste(){
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Pedro");
		Filme filme = new Filme("Vingadores Ultimato", 1, 10.0);
		
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
			
		//Testes
		assertThat(locacao.getValor(), CoreMatchers.is(10.0));
		assertThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.not(12.0)));
		assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}
