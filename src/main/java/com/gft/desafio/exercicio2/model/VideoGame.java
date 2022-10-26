package com.gft.desafio.exercicio2.model;

public class VideoGame extends Produto implements Imposto {
	
	private String marca;
	private String modelo;
	private boolean isUsado;
	
	public VideoGame() {}
	
	public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado) {
		super(nome, preco, qtd);
		this.marca = marca;
		this.modelo = modelo;
		this.isUsado = isUsado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isUsado() {
		return isUsado;
	}

	public void setUsado(boolean isUsado) {
		this.isUsado = isUsado;
	}

	@Override
	public double calculaImposto() {
		double aliquota = 0, imposto = 0;
		String mensagem = "";
		if (isUsado()) {
			aliquota = 0.25;
			mensagem = "usado, ";
		} else {
			aliquota = 0.45;
		}
		imposto = getPreco() * aliquota;
		System.out.println(String.format("Imposto %s %s %sR$ %.1f.", getNome(), getModelo(), mensagem, imposto));
		return imposto;
	}
	
	
}
