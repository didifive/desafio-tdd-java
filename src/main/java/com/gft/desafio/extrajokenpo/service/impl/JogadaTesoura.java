package com.gft.desafio.extrajokenpo.service.impl;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.service.VerificaVencedor;

public class JogadaTesoura implements VerificaVencedor {

	@Override
	public int verificaVencedorContra(Jogada outraJogada) {
		if (outraJogada.equals(Jogada.TESOURA)) {
			return 0;
		}
		return (outraJogada.equals(Jogada.PAPEL)) ? 1 : 2;
	}

}
