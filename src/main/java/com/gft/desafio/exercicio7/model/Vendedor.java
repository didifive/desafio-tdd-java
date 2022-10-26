package com.gft.desafio.exercicio7.model;

public class Vendedor extends Funcionario {

	public Vendedor() {}

	public Vendedor(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}
	
	@Override
	public double bonificacao() {
		return (getSalario() + 3000.00);
	}

	@Override
	public String toString() {
		return "Vendedor "
				+ super.toString();
	}
	
}
