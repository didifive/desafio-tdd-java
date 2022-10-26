package com.gft.desafio.exercicio2.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoGameTest {
	
	private VideoGame videoGame;
	
	@Before
	public void setup() {
		videoGame = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
	}
	
	@Test
	public void deveCalcularImpostoDe25PorCentroParaVideoGameUsado() throws Exception {
		videoGame.setUsado(true);
		double imposto = videoGame.calculaImposto();
		assertEquals(450.0, imposto, 0.0001);
	}
	
	@Test
	public void deveCalcularImpostoDe45PorCentroParaVideoGameNaoUsado() throws Exception {
		double imposto = videoGame.calculaImposto();
		assertEquals(810.0, imposto, 0.0001);
	}

}
