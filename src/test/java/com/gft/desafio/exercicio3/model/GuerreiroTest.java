package com.gft.desafio.exercicio3.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;


public class GuerreiroTest {
	
	private Guerreiro guerreiro;
	
	@Spy
	private Guerreiro guerreiroSpy; 
	
	
	@Before
	public void setup() {
		guerreiro = new Guerreiro("Aragorn", 1000, 1, 0, 1, 1, 1, new ArrayList<>());
	}
	
	@Test
	public void deveAumentarLevelEm1QuandoOGuerreiroGanharLevel() throws Exception {
		guerreiro.lvlUp();
		int lvl = guerreiro.getLevel();
		
		assertEquals(2, lvl);
	}
	
	@Test
	public void deveAumentarOAtributoVidaEm3QuandoOGuerreiroGanharLevel() throws Exception {
		guerreiro.lvlUp();
		int vida = guerreiro.getVida();

		assertEquals(1003, vida);
	}
	
	@Test
	public void deveAumentarOAtributoForcaEm3QuandoOGuerreiroGanharLevel() throws Exception {
		guerreiro.lvlUp();
		int forca = guerreiro.getForca();

		assertEquals(4, forca);
	}
	
	@Test
	public void deveAumentarOAtributoManaEm1QuandoOGuerreiroGanharLevel() throws Exception {
		guerreiro.lvlUp();
		int mana = guerreiro.getMana();

		assertEquals(2, mana);
	}
	
	@Test
	public void deveRealizarAtaqueComOCalculoDeForcaMultiplicadoPorLevelEAcrescimoRandomicoDe0Ate300() throws Exception {
		guerreiroSpy = spy(guerreiro);
		when(guerreiroSpy.getRandom(300)).thenReturn(50);
		
		int attack = guerreiroSpy.attack();
		
		assertEquals(51, attack);
	}
	
	@Test
	public void deveAprenderHabilidade() throws Exception {
		guerreiro.aprenderHabilidade("Habilidade");

		assertThat(guerreiro.getHabilidade(), hasItem("Habilidade"));
	}

}
