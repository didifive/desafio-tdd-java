package com.gft.desafio.exercicio7.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendedorTest {
	
	@Test
	public void deveCalcularBonificacaoParaVendedorAdicionando3000() throws Exception {
		
		Funcionario vendedor = new Vendedor();
		vendedor.setSalario(10000);
		double bonificacao = vendedor.bonificacao();
		
		assertEquals(13000, bonificacao, 0.00001);
		
	}

}
