package com.gft.desafio.extrajokenpo.service;

import java.util.Random;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.model.Jogador;

public class JokenpoService {
	
	Random rd = new Random();
	int quantidadeDeJogadas = Jogada.values().length;
	
	public void jogar(Jogador jogador) {
		jogador.setJogada(Jogada.values()[rd.nextInt(quantidadeDeJogadas)]);
	}
	
	public void jogar(Jogador jogador, Jogada jogada) {
		jogador.setJogada(jogada);
	}

	public int verificarVencedor(Jogador jogador, Jogador jogadorDois) {
		return jogador.getJogada().getValue().verificaVencedorContra(jogadorDois.getJogada());
	}

}
