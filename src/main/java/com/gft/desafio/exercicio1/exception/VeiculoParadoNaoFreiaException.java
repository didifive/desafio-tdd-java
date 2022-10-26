package com.gft.desafio.exercicio1.exception;

public class VeiculoParadoNaoFreiaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoParadoNaoFreiaException(String marca, String modelo) {
    super(String.format("Não é possível frear com o veículo \'%s/%s\' parado!", marca, modelo));
	}

}
