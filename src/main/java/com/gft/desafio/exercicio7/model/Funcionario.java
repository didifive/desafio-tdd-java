package com.gft.desafio.exercicio7.model;

public abstract class Funcionario {

	private String nome;
  private int idade;
  private double salario;
  
  protected Funcionario() {}
  
	protected Funcionario(String nome, int idade, double salario) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double bonificacao() {
  	return getSalario();
  }
  
  @Override
  public String toString() {
      return nome
      		+ ", Idade: " + idade 
      		+ ", Salário: R$ " + String.format("%.2f",salario)
      		+ ", Bonificação: R$ " + String.format("%.2f",bonificacao());
  }
}
