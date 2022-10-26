package com.gft.desafio.exercicio3.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

public class MagoTest {
	
	private Mago mago;
	
	@Spy
	private Mago magoSpy; 
	
	@Before
	public void setup() {
		mago = new Mago("Gandalf", 500, 1, 0, 1, 1, 1, new ArrayList<>());
	}
	
	@Test
	public void deveAumentarLevelEm1QuandoOMagoGanharLevel() throws Exception {
		mago.lvlUp();
		int lvl = mago.getLevel();
		
		assertEquals(2, lvl);
	}
	
	@Test
	public void deveAumentarOAtributoManaEm3QuandoOMagoGanharLevel() throws Exception {
		mago.lvlUp();
		int mana = mago.getMana();

		assertEquals(4, mana);
	}
	
	@Test
	public void deveAumentarOAtributoInteligenciaEm3QuandoOMagoGanharLevel() throws Exception {
		mago.lvlUp();
		int inteligencia = mago.getInteligencia();

		assertEquals(4, inteligencia);
	}
	
	@Test
	public void deveAumentarOAtributoVidaEm1QuandoOMagoGanharLevel() throws Exception {
		mago.lvlUp();
		int vida = mago.getVida();

		assertEquals(501, vida);
	}
	
	@Test
	public void deveAumentarOAtributoForcaEm1QuandoOMagoGanharLevel() throws Exception {
		mago.lvlUp();
		int forca = mago.getForca();

		assertEquals(2, forca);
	}
	
	@Test
	public void deveRealizarAtaqueComOCalculoDeInteligenciaMultiplicadoPorLevelEAcrescimoRandomicoDe0Ate300() throws Exception {
		magoSpy = spy(mago);
		when(magoSpy.getRandom(300)).thenReturn(50);
		
		int attack = magoSpy.attack();
		
		assertEquals(51, attack);
	}
	
	@Test
	public void deveAprenderMagia() throws Exception {
		mago.aprenderMagia("Magia");

		assertThat(mago.getMagia(), hasItem("Magia"));
	}

}
