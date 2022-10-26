package com.gft.desafio.exercicio1.exception;

public class VeiculoEmMovimentoNaoPodeSerDesligadoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoEmMovimentoNaoPodeSerDesligadoException(String marca, String modelo, int velocidade) {
		super(String.format("O veículo \'%s/%s\' está em movimento com \'%dKm/h\' de velocidade, não é possível desligar!", marca, modelo, velocidade));
	}

}
