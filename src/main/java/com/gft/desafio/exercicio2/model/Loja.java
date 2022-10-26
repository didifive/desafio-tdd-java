package com.gft.desafio.exercicio2.model;

import java.util.List;

public class Loja {
	
	private String nome;
	private String cnpj;
	List<Livro> livros;
	List<VideoGame> videoGames;
	
	public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.livros = livros;
		this.videoGames = videoGames;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}
	
	public void listaLivros() {
		System.out.println("-".repeat(100));
		if (getLivros().isEmpty()) {
			System.out.println("A loja não tem livros no seu estoque.");
		} else {
			System.out.printf("A loja %s possui estes livros para venda:\n",getNome());
			getLivros().forEach(l -> System.out.printf("Titulo: %s , preço: %.1f , quantidade: %d em estoque.\n"
					, l.getNome(), l.getPreco(), l.getQtd()));
		}
	};
	
	public void listaVideoGames() {
		System.out.println("-".repeat(100));
		if (getVideoGames().isEmpty()) {
			System.out.println("A loja não tem video-games no seu estoque.");
		} else {
			System.out.printf("A loja %s possui estes video-games para venda:\n",getNome());
			getVideoGames().forEach(g -> System.out.printf("Video-game: %s , preço: %.1f , quantidade: %d em estoque.\n"
					, g.getModelo(), g.getPreco(), g.getQtd()));
		}
	};
	
	public double calculaPatrimonio() {
		double patrimonio = 0;
		System.out.println("-".repeat(100));
		for (Livro livro : getLivros()) patrimonio += (livro.getPreco() * livro.getQtd());
		for (VideoGame game : getVideoGames()) patrimonio += (game.getPreco() * game.getQtd());
		System.out.printf("O patrimonio da loja: %s é de R$ %.1f\n", getNome(), patrimonio);
		return patrimonio;
	};

}
