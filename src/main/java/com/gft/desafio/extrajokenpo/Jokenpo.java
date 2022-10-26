package com.gft.desafio.extrajokenpo;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import com.gft.desafio.extrajokenpo.enums.Jogada;
import com.gft.desafio.extrajokenpo.model.Jogador;
import com.gft.desafio.extrajokenpo.service.JokenpoService;

/**
 * Desafio Extra Jokenpo.
 * 
 * @see https://dojopuzzles.com/problems/jokenpo/
 */
public class Jokenpo {

	public static void main(String[] args) {
		Scanner scj = new Scanner(System.in);
		
		jogo(scj);
		
		if (Objects.isNull(args)) {
			scj.close();
		}
		
	}

	private static void jogo(Scanner sc) {
		JokenpoService jokenpoService = new JokenpoService();
		Jogador jogadorUm, jogadorDois;
		boolean jogo;
		
		do {
			jogo = false;
  		
			System.out.println("=".repeat(100));
			System.out.println("Seja Bem-vindo(a) ao jogo de Jokenpo!");
  		
  		System.out.println("Digite o nome do jogador(a) 1: ");
  		jogadorUm = new Jogador(sc.next());
  		
  		System.out.println("Digite o nome do jogador(a) 2: ");
  		jogadorDois = new Jogador(sc.next());
  		
  		fazerJogada(jogadorUm, jokenpoService, sc);
  		
  		System.out.println("-".repeat(100));
  		
  		fazerJogada(jogadorDois, jokenpoService, sc);
  		
  		System.out.println("=".repeat(100));
  		System.out.println("Após as jogadas temos aqui o resultado:");
  		
  		verificaVencedor(jokenpoService, jogadorUm, jogadorDois);
  		
  		jogo = sairJogo(sc);

		}while(jogo);
		
  	System.out.println("=".repeat(100));
		System.out.println("FIM DO PROGRAMA JOKENPO");
	}

	private static boolean sairJogo(Scanner sc) {
		String respostaReiniciar;
		boolean jogo, pergunta;
		
		do {
			jogo = false;
			pergunta = false;
  		System.out.println("=".repeat(100));
  		System.out.println("Deseja Reiniciar o Jogo? (S/N)");
  		respostaReiniciar = sc.next();
  		switch (respostaReiniciar) {
  			case "S":
  			case "s":
  				jogo = true;
  				break;
  			case "N":
  			case "n":
  				jogo = false;
  				break;
  			default:
  				System.out.println("Por favor, digite 'S' para Reiniciar o Jogo ou 'N' para Sair!");
  				pergunta = true;
  				break;
  		}
		}while(pergunta);
		return jogo;
	}

	private static void verificaVencedor(JokenpoService jokenpoService, Jogador jogadorUm, Jogador jogadorDois) {
		String resposta;
		
		final String PARTE1 = "O jogador ";
		final String PARTE2 = " é o VENCEDOR com a Jogada: ";
		
		int resultado = jokenpoService.verificarVencedor(jogadorUm, jogadorDois);
		
		switch (resultado) {
  		case 0:
  			resposta = "Os jogadores EMPATARAM!";
  			break;
  		case 1:
  			resposta = PARTE1 + jogadorUm.getNome() + PARTE2 + jogadorUm.getJogada();
  			break;
  		case 2:
  			resposta = PARTE1 + jogadorDois.getNome() + PARTE2 + jogadorDois.getJogada();
  			break;
  		default:
  			resposta = "Erro Fatal!";
  			break;
		}
		
		System.out.println(resposta);
	}

	private static void fazerJogada(Jogador jogador, JokenpoService jokenpoService, Scanner sc) {
		Boolean refazerJogada;
		do {
			refazerJogada = false;
  		
			System.out.println("Para o Jogador " + jogador.getNome() + " gostaria de fazer jogada automática? (S/N)");
  		String respostaJogadaJogadorUmString = sc.next();
  		
  		switch (respostaJogadaJogadorUmString) {
  			case "S":
  			case "s":
  				jokenpoService.jogar(jogador);
  				break;
  			case "N":
  			case "n":
  				fazerJogadaManual(jogador,jokenpoService,sc);
  				break;
  			default:
  				System.out.println("Por favor, digite 'S' para jogada automática ou 'N' para jogada manual!");
  				refazerJogada = true;
  				break;
  		}
		}while(refazerJogada);
		
		System.out.println("-".repeat(100));
		System.out.println("O jogador " + jogador.getNome() + " fez a jogada: " + jogador.getJogada().toString() + "!");
	}
	
	private static void fazerJogadaManual(Jogador jogador, JokenpoService jokenpoService, Scanner sc) {
		Boolean refazerJogada;
		
		do {
			refazerJogada = false;
  		
			gerarListaDeJogadas();
  		System.out.println("Escolha o número da jogada conforme a lista acima para o jogador "+ jogador.getNome() + " ");
  		
  		try {
  			int numeroJogada = sc.nextInt();
  			if (numeroJogada > Jogada.values().length || numeroJogada < 1) {
    			System.out.println("Digite um número válido dentre as opções listadas!");
    			refazerJogada = true;
    		} else {
    			jokenpoService.jogar(jogador, Jogada.values()[numeroJogada-1]);
    		}
  		} catch (InputMismatchException e) {
  			System.out.println("Digite um NÚMERO válido dentre as opções listadas!");
  			refazerJogada = true;
  			sc.next();
			} 
  		
		}while(refazerJogada);
	}
	
	public static void gerarListaDeJogadas() {
		for(int i = 0; i < Jogada.values().length; i++) {
			System.out.println((i+1)+"- "+Jogada.values()[i].toString());
		}
	}

}
