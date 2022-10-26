package com.gft.desafio.exercicio1.exception;

public class VeiculoJaEstaDesligadoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoJaEstaDesligadoException(String marca, String modelo) {
		super(String.format("O veículo \'%s/%s\' já está desligado, não é possível desligar novamente!", marca, modelo));
	}
}

