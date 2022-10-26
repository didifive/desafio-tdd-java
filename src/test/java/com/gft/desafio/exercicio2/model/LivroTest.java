package com.gft.desafio.exercicio2.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivroTest {
	
	private Livro livro;
	
	@Before
	public void setup() {
		livro = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);
	}
	
	@Test
	public void naoDeveCalcularImpostoParaLivroComTemaEducativo() throws Exception {
		double imposto = livro.calculaImposto();
		assertEquals(0.0, imposto, 0.0001);
	}
	
	@Test
	public void deveCalcularImpostoParaLivroComQualquerTema_ExcetoEducativo() throws Exception {
		livro.setTema("Aventura");
		double imposto = livro.calculaImposto();
		assertEquals(2.0, imposto, 0.0001);
	}

}
