package com.gft.desafio.exercicio3;

import java.util.ArrayList;
import java.util.List;

import com.gft.desafio.exercicio3.model.Guerreiro;
import com.gft.desafio.exercicio3.model.Mago;
import com.gft.desafio.exercicio3.model.Personagem;
import com.gft.desafio.exercicio3.model.QuantidadePersonagens;

public class Exercicio3 {
	public static void main(String[] args) {
		
		quantidadeDePersonagens();
		
		Mago mago1 = new Mago("Gandalf", 500, 1000, 0, 1000, 1, 1, new ArrayList<>());
		Mago mago2 = new Mago("Ronaldinho", 500, 1000, 5000, 1000, 1, 1, new ArrayList<>());
		List<Mago> magos = new ArrayList<>();
		magos.add(mago1);
		magos.add(mago2);
		
		List<Personagem> personagens = new ArrayList<>();
		personagens.addAll(magos);
		
		statusPersonagens(personagens);
		
		Guerreiro guerreiro1 = new Guerreiro("Aragorn", 5000, 100, 0, 1, 1000, 1, new ArrayList<>());
		Guerreiro guerreiro2 = new Guerreiro("Musashi", 5000, 100, 8000, 1, 1000, 1, new ArrayList<>());
		List<Guerreiro> guerreiros = new ArrayList<>();
		guerreiros.add(guerreiro1);
		guerreiros.add(guerreiro2);
		
		personagens.addAll(guerreiros);
		
		statusPersonagens(personagens);
		
		mago1.aprenderMagia("Bola de fogo");
		mago1.aprenderMagia("Turbilhão de Fogo");
		
		mago2.aprenderMagia("Drilhe furioso");
		mago2.aprenderMagia("Cobrança no gol");
		mago2.aprenderMagia("Onipresença nos roles");
		
		magos.forEach(m -> {
			m.aprenderMagia("Teletransporte");
			m.aprenderMagia("Telecinese");
			acaoPersonagem(m);
		});
		
		guerreiro1.aprenderHabilidade("Empunhar espada de duas mãos (Passivo)");
		guerreiro1.aprenderHabilidade("Espada Martelo");
		
		guerreiro2.aprenderHabilidade("Empunhar Katanas (Passivo)");
		guerreiro2.aprenderHabilidade("Golpe Cruzado");
				
		guerreiros.forEach(g -> {
			g.aprenderHabilidade("SuperForça");
			g.aprenderHabilidade("Ataque Surpresa");
			acaoPersonagem(g);
		});
				
		statusPersonagens(personagens);
	}

	private static void statusPersonagens(List<Personagem> personagens) {
		System.out.println("=".repeat(50) + " STATUS PERSONAGENS " + "=".repeat(50));
		quantidadeDePersonagens();
		personagens.forEach(System.out::println);
		System.out.println("=".repeat(52) + "  FIM  STATUS  " + "=".repeat(53));
	}

	private static void acaoPersonagem(Personagem p) {
		for (int i=0; i<5; i++) p.lvlUp(); 
		for (int i=0; i<15; i++) p.attack();
	}

	private static void quantidadeDePersonagens() {
		System.out.printf("-> A quantidade de personagens atualmente é: %d\n", QuantidadePersonagens.quantidadePersonagens);
	}

}
