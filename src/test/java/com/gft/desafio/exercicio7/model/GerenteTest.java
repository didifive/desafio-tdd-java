package com.gft.desafio.exercicio7.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GerenteTest {
	
	@Test
	public void deveCalcularBonificacaoParaGerenteAdicionando10000() throws Exception {
		
		Funcionario gerente = new Gerente();
		gerente.setSalario(10000);
		double bonificacao = gerente.bonificacao();
		
		assertEquals(20000, bonificacao, 0.00001);
		
	}

}
