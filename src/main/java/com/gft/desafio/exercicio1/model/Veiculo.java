package com.gft.desafio.exercicio1.model;

import com.gft.desafio.exercicio1.exception.LimiteDoTanqueUltrapassadoException;
import com.gft.desafio.exercicio1.exception.VeiculoDesligadoNaoAceleraException;
import com.gft.desafio.exercicio1.exception.VeiculoEmMovimentoNaoPodeSerDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaLigadoException;
import com.gft.desafio.exercicio1.exception.VeiculoParadoNaoFreiaException;

public class Veiculo{

	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private float km;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	private double preco;
	
	public Veiculo() {
		this.marca = "";
		this.modelo = "";
		this.placa = "";
		this.cor = "";
		this.km = 0f;
		this.isLigado = false;
		this.litrosCombustivel = 0;
		this.velocidade = 0;
		this.preco = 0d;
	}
	
	public Veiculo(String marca, String modelo, String placa, String cor, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.km = 0f;
		this.isLigado = false;
		this.litrosCombustivel = 0;
		this.velocidade = 0;
		this.preco = preco;
	}
	
	public Veiculo(String marca, String modelo, String placa, String cor, float km, boolean isLigado,
			int litrosCombustivel, int velocidade, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.km = km;
		this.isLigado = isLigado;
		this.litrosCombustivel = litrosCombustivel;
		this.velocidade = velocidade;
		this.preco = preco;
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		this.km = km;
	}
	public boolean isLigado() {
		return isLigado;
	}
	public void setLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}
	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}
	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void acelerar() throws VeiculoDesligadoNaoAceleraException {
		if (isLigado) {
			int velocidade = getVelocidade();
			velocidade += 20;
			setVelocidade(velocidade);
		} else {
			throw new VeiculoDesligadoNaoAceleraException(getMarca(), getModelo());
		}
	}
	
	public void abastecer(int combustivel) throws LimiteDoTanqueUltrapassadoException {
		int limiteTanque=60;
		int litrosCombustivel = getLitrosCombustivel() + combustivel;
		if (litrosCombustivel <= limiteTanque) {
			setLitrosCombustivel(litrosCombustivel);
		} else {
			setLitrosCombustivel(limiteTanque);
			int excesso = litrosCombustivel - limiteTanque;
			throw new LimiteDoTanqueUltrapassadoException(getMarca(), getModelo(), excesso);
		}
	}
	
	public void frear() throws VeiculoParadoNaoFreiaException {
		int velocidade = getVelocidade();
		if (velocidade > 0) {
			if (velocidade < 20) {
				velocidade = 0;
			}	else {
				velocidade -= 20;
			}
			setVelocidade(velocidade);
		} else {
			throw new VeiculoParadoNaoFreiaException(getMarca(), getModelo());
		}
	}
	
	public void pintar(String cor) {
		setCor(cor);
	}
	
	public void ligar() throws VeiculoJaEstaLigadoException {
		if (!isLigado) {
			setLigado(true);
		} else {
			throw new VeiculoJaEstaLigadoException(getMarca(), getModelo());
		}
	}
	
	public void desligar() throws VeiculoJaEstaDesligadoException, VeiculoEmMovimentoNaoPodeSerDesligadoException {
		if (isLigado) {
			int velocidade = getVelocidade();
			if (velocidade == 0) {
				setLigado(false);
			} else {
				throw new VeiculoEmMovimentoNaoPodeSerDesligadoException(getMarca(), getModelo(), velocidade);
			}
		} else {
			throw new VeiculoJaEstaDesligadoException(getMarca(), getModelo());
		}

	}
	
	@Override
	public String toString() {
		String ligado = (isLigado) ? "está ligado" : "está DESligado";
		return "Veículo [" + marca 
				+ "/" + modelo 
				+ ", placa: " + placa 
				+ ", cor: " + cor 
				+ ", km: " + String.format("%.1f", km)
				+ ", " + ligado
				+ ", combustível (l): " + litrosCombustivel 
				+ ", velocidade (Km/h): " + velocidade
				+ ", preço (R$): " + String.format("%.2f", preco) + "]";
	}
	
}
