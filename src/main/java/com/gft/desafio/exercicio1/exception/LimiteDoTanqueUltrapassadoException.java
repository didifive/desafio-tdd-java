package com.gft.desafio.exercicio1.exception;

public class LimiteDoTanqueUltrapassadoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LimiteDoTanqueUltrapassadoException(String marca, String modelo, int excesso) {
    super(String.format("Limite do tanque do veículo \'%s/%s\' foi ultrapassado em \'%d\' litros, tanque está cheio!", marca, modelo, excesso));
	}

}
