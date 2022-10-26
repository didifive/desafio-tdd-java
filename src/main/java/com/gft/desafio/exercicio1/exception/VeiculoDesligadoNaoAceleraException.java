package com.gft.desafio.exercicio1.exception;

public class VeiculoDesligadoNaoAceleraException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoDesligadoNaoAceleraException(String marca, String modelo) {
    super(String.format("Não é possível acelerar com o veículo \'%s/%s\' desligado!", marca, modelo));
	}

}
