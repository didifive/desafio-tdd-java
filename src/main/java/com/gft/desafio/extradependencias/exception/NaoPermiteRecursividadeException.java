package com.gft.desafio.extradependencias.exception;

public class NaoPermiteRecursividadeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NaoPermiteRecursividadeException(String ascendente, String tokenAtual) {
		super(String.format("O token \'%s\' já é Ascendente de \'%s\', portando não pode ser adicionado como Dependente",ascendente,tokenAtual));
	}
	
}
