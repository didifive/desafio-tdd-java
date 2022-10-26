package com.gft.desafio.extrajokenpo.service;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.model.Jogador;

public class JokenpoServiceTest {
	
	private Jogador jogadorUm;
	private Jogador jogadorDois;
	private JokenpoService jokenpoService;
	
	private void assertJogada(Jogador jogador) {
		assertThat(jogador.getJogada(), isA(Jogada.class));
	}
	
	@Before
	public void setup() {
		jogadorUm = new Jogador("João");
		jogadorDois = new Jogador("Maria");
		jokenpoService = new JokenpoService();
	}
	
	@Test
	public void jogadorDeveFazerSuaJogadaAutomatica() throws Exception {
		jokenpoService.jogar(jogadorUm);
		assertJogada(jogadorUm);
	}
	
	public void jogadorDeveFazerSuaJogadaManual() throws Exception {
		jokenpoService.jogar(jogadorUm, Jogada.PAPEL);
		assertJogada(jogadorUm);
	}
	
	@Test
	public void deveVerificarSeJogadoresEmpataram() throws Exception {
		jokenpoService.jogar(jogadorUm, Jogada.PAPEL);
		jokenpoService.jogar(jogadorDois, Jogada.PAPEL);
		
		int resultado = jokenpoService.verificarVencedor(jogadorUm, jogadorDois);
		
		assertEquals(0, resultado);
		
	}
	
	@Test
	public void deveVerificarSeJogadorUmVence() throws Exception {
		jokenpoService.jogar(jogadorUm, Jogada.PAPEL);
		jokenpoService.jogar(jogadorDois, Jogada.PEDRA);
		
		int resultado = jokenpoService.verificarVencedor(jogadorUm, jogadorDois);
		
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void deveVerificarSeJogadorUmPerde() throws Exception {
		jokenpoService.jogar(jogadorUm, Jogada.PAPEL);
		jokenpoService.jogar(jogadorDois, Jogada.TESOURA);
		
		int resultado = jokenpoService.verificarVencedor(jogadorUm, jogadorDois);
		
		assertEquals(2, resultado);
		
	}
	
}
