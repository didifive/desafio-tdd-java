package com.gft.desafio.exercicio7;

import com.gft.desafio.exercicio7.model.Funcionario;
import com.gft.desafio.exercicio7.model.Gerente;
import com.gft.desafio.exercicio7.model.Supervisor;
import com.gft.desafio.exercicio7.model.Vendedor;

public class Exercicio7 {

	public static void main(String[] args) {
		Funcionario gerente = new Gerente("Tobias José", 45, 25000.00);
		Funcionario supervisor = new Supervisor("João Carlos", 35, 10000.00);
		Funcionario vendedor = new Vendedor("José Manuel", 25, 5000.00);

    System.out.println("Lista de Colaboradores:");
    System.out.printf("%s\n","-".repeat(100));
    System.out.println(gerente);
    System.out.printf("%s\n","-".repeat(100));
    System.out.println(supervisor);
    System.out.printf("%s\n","-".repeat(100));
    System.out.println(vendedor);
    System.out.printf("%s\n","-".repeat(100));
	}

}
