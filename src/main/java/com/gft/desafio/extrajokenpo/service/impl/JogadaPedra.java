package com.gft.desafio.extrajokenpo.service.impl;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.service.VerificaVencedor;

public class JogadaPedra implements VerificaVencedor {

	@Override
	public int verificaVencedorContra(Jogada outraJogada) {
		if (outraJogada.equals(Jogada.PEDRA)) {
			return 0;
		}
		return (outraJogada.equals(Jogada.TESOURA)) ? 1 : 2;
	}

}
