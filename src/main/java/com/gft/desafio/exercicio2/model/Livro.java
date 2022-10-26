package com.gft.desafio.exercicio2.model;

public class Livro extends Produto implements Imposto {
	
	private String autor;
	private String tema;
	private int qtdPag;
	
	public Livro() {}

	public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) {
		super(nome, preco, qtd);
		this.autor = autor;
		this.tema = tema;
		this.qtdPag = qtdPag;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	@Override
	public double calculaImposto() {
		double imposto = (getPreco() * 0.1);
		String mensagem = "";
		if (getTema().equals("educativo")) {
			mensagem = String.format("Livro educativo não tem imposto: %s.", getNome());
			imposto = 0;
		} else {
			mensagem = String.format("R$ %.1f de impostos sobre o livro %s.", imposto, getNome());
		}
		System.out.println(mensagem);
		return imposto;
	}
	
}
