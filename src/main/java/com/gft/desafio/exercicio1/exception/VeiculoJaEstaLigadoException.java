package com.gft.desafio.exercicio1.exception;

public class VeiculoJaEstaLigadoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoJaEstaLigadoException(String marca, String modelo) {
		super(String.format("O veículo \'%s/%s\' já está ligado, não é possível ligar novamente!", marca, modelo));
	}

}
