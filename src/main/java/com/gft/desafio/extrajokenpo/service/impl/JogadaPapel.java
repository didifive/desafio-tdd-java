package com.gft.desafio.extrajokenpo.service.impl;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.service.VerificaVencedor;

public class JogadaPapel implements VerificaVencedor {

	@Override
	public int verificaVencedorContra(Jogada outraJogada) {
		if (outraJogada.equals(Jogada.PAPEL)) {
			return 0;
		}
		return (outraJogada.equals(Jogada.PEDRA)) ? 1 : 2;
	}

}
