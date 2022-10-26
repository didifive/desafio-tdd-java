package com.gft.desafio.exercicio1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gft.desafio.exercicio1.exception.LimiteDoTanqueUltrapassadoException;
import com.gft.desafio.exercicio1.exception.VeiculoDesligadoNaoAceleraException;
import com.gft.desafio.exercicio1.exception.VeiculoEmMovimentoNaoPodeSerDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaLigadoException;
import com.gft.desafio.exercicio1.exception.VeiculoParadoNaoFreiaException;

public class VeiculoTest {
	
	private Veiculo veiculo;
	
	@Before
	public void setup() {
		veiculo = new Veiculo("Volkswagen", "Gol", "ABC1D234", "Prata", 0.0f, true, 0, 0, 35000.00);
	}
	
	@Test
	public void deveInstanciarVeiculoComInformacoesResumidas_MarcaModeloPlacaCorPreco() throws Exception {
		Veiculo veiculo = new Veiculo("Volkswagen", "Gol", "ABC1D234", "Prata", 35000.00);
		
		assertEquals("Volkswagen", veiculo.getMarca());
		assertEquals("Gol",veiculo.getModelo());
		assertEquals("ABC1D234", veiculo.getPlaca());
		assertEquals("Prata", veiculo.getCor());
		assertEquals(0, veiculo.getKm(), 0.00001);
		assertFalse(veiculo.isLigado());
		assertEquals(0, veiculo.getLitrosCombustivel());
		assertEquals(0, veiculo.getVelocidade());
		assertEquals(35000.00, veiculo.getPreco(), 0.00001);
	}
	
	@Test
	public void deveAcelerarSeVeiculoEstaLigadoAumentandoAVelocidadeEm20() throws Exception {
		veiculo.acelerar();
		int velocidade = veiculo.getVelocidade();
		
		assertEquals(20, velocidade);
	}
	
	@Test(expected = VeiculoDesligadoNaoAceleraException.class)
	public void naoAceitarAcelerarSeVeiculoEstaDesligado() throws Exception {
		veiculo.setLigado(false);
		veiculo.acelerar();
	}
	
	@Test
	public void deveAceitarAbastecer50LitrosDeCombustivel() throws Exception {
		veiculo.abastecer(50);
		int litrosCombustivel = veiculo.getLitrosCombustivel();
		
		assertEquals(50, litrosCombustivel);
	}
	
	@Test(expected = LimiteDoTanqueUltrapassadoException.class)
	public void naoAceitarAbastecerMaisDe60LitrosDeCombustivel() throws Exception {
		veiculo.abastecer(61);
	}
	
	@Test
	public void deveFrearSeVeiculoEstaEmMovimentoDiminuindoAVelocidadeEm20() throws Exception {
		veiculo.setVelocidade(20);
		veiculo.frear();
		int velocidade = veiculo.getVelocidade();
		
		assertEquals(0, velocidade);
	}
	
	@Test(expected = VeiculoParadoNaoFreiaException.class)
	public void naoAceitarFrearQuandoVeiculoEstiverParado() throws Exception {
		veiculo.frear();
	}
	
	@Test
	public void deveMudarACorDoVeiculoQuantoPintar() throws Exception {
		veiculo.pintar("VERDE");
		String cor = veiculo.getCor();
		assertEquals("VERDE", cor);
	}
	
	@Test
	public void deveLigarOVeiculoSeVeiculoEstaDesligado() throws Exception {
		veiculo.setLigado(false);
		veiculo.ligar();
		boolean status = veiculo.isLigado();
		assertTrue(status);
	}
	
	@Test(expected = VeiculoJaEstaLigadoException.class)
	public void naoAceitarLigarVeículoQueJaEstaLigado() throws Exception {
		veiculo.ligar();
	}
	
	@Test
	public void deveDesligarOVeiculoSeEstiverLigadoEParado() throws Exception {
		veiculo.desligar();
		boolean status = veiculo.isLigado();
		assertFalse(status);
	}
	
	@Test(expected = VeiculoJaEstaDesligadoException.class)
	public void naoAceitarDesligarVeiculoQueJaEstaDesligado() throws Exception {
		veiculo.setLigado(false);
		veiculo.desligar();
	}
	
	@Test(expected = VeiculoEmMovimentoNaoPodeSerDesligadoException.class)
	public void naoAceitarDesligarVeiculoQueEstaEmMovimento() throws Exception {
		veiculo.acelerar();
		veiculo.desligar();
	}

}
