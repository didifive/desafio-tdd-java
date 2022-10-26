package com.gft.desafio.exercicio2.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LojaTest {
	
	private Loja loja;
	private Livro livro;
	private VideoGame videoGame;
	
	@Before
	public void setup() {
		livro = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);
		List<Livro> livros = new ArrayList<>();
		livros.add(livro);
		livros.add(livro);	
		videoGame = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		List<VideoGame> games = new ArrayList<>();
		games.add(videoGame);
		games.add(videoGame);

		loja = new Loja("Loja", "12345678910", livros, games);
	}
	
	
	@Test
	public void deveListarTodosOsLivrosDaLoja() throws Exception {
		List<Livro> livrosTest = loja.getLivros();
		
		assertThat(livrosTest, hasItem(livro));
		assertEquals(2, livrosTest.size());
	}
	
	@Test
	public void deveListarNoConsoleTodosOsLivrosDaLoja() throws Exception {
		loja.listaLivros();
	}
	
	@Test
	public void quandoNaoTiverLivroDeveAvisarNoConsoleQueALojaNaoPossuiOProdutoNoEstoque() throws Exception {
		loja.setLivros(new ArrayList<>());
		loja.listaLivros();
	}
	
	@Test
	public void deveListarTodosOsVideoGamesDaLoja() throws Exception {
		List<VideoGame> videoGamesTest = loja.getVideoGames();
		
		assertThat(videoGamesTest, hasItem(videoGame));
		assertEquals(2, videoGamesTest.size());
	}
	
	@Test
	public void deveListarNoConsoleTodosOsVideoGamesDaLoja() throws Exception {
		loja.listaVideoGames();
	}
	
	@Test
	public void quandoNaoTiverVideoGameDeveAvisarNoConsoleQueALojaNaoPossuiOProdutoNoEstoque() throws Exception {
		loja.setVideoGames(new ArrayList<>());
		loja.listaVideoGames();
	}
	
	@Test
	public void deveCalcularOPatrimonioDaLoja() throws Exception {
		double patrimonio = loja.calculaPatrimonio();
		
		assertEquals(362000.0, patrimonio, 0.00001);;
	}

}
