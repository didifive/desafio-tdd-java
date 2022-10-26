package com.gft.desafio.exercicio3.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuantidadePersonagensTest {
	
	@Test
	public void deveAumentarAQuantidadeDePersonagensEm20AoCriar10MagosE10Guerreiros() throws Exception {
		
		int quantidadePersonagens = QuantidadePersonagens.quantidadePersonagens;
		
		List<Mago> magos = new ArrayList<>();
		for (int i=0; i<10; i++)	magos.add(new Mago());
		List<Guerreiro> guerreiros = new ArrayList<>();
		for (int i=0; i<10; i++)	guerreiros.add(new Guerreiro());
						
		int quantidadePersonagensAposCriacao = QuantidadePersonagens.quantidadePersonagens;
		
		int acrescimo = quantidadePersonagensAposCriacao - quantidadePersonagens;
		
		assertEquals(20, acrescimo);
		
	}

}
