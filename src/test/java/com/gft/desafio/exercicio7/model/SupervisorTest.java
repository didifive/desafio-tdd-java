package com.gft.desafio.exercicio7.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupervisorTest {
	
	@Test
	public void deveCalcularBonificacaoParaSupervisorAdicionando5000() throws Exception {
		
		Funcionario supervisor = new Supervisor();
		supervisor.setSalario(10000);
		double bonificacao = supervisor.bonificacao();
		
		assertEquals(15000, bonificacao, 0.00001);
		
	}

}
