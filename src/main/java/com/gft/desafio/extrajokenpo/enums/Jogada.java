package com.gft.desafio.extrajokenpo.enums;

import com.gft.desafio.extrajokenpo.service.VerificaVencedor;
import com.gft.desafio.extrajokenpo.service.impl.JogadaPapel;
import com.gft.desafio.extrajokenpo.service.impl.JogadaPedra;
import com.gft.desafio.extrajokenpo.service.impl.JogadaTesoura;

public enum Jogada {
	
	PEDRA(new JogadaPedra()),
	PAPEL(new JogadaPapel()),
	TESOURA(new JogadaTesoura());
	
	VerificaVencedor verificaVencedor;
	
	Jogada(VerificaVencedor verificaVencedor) {
		this.verificaVencedor = verificaVencedor;
	}

	public VerificaVencedor getValue() {
		return verificaVencedor;
	}

}
