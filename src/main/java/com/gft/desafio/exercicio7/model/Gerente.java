package com.gft.desafio.exercicio7.model;

public class Gerente extends Funcionario {

	public Gerente() {}

	public Gerente(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}
	
	@Override
	public double bonificacao() {
		return (getSalario() + 10000.00);
	}

	@Override
	public String toString() {
		return "Gerente "
				+ super.toString();
	}
	
}
