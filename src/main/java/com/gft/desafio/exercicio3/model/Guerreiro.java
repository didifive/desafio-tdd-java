package com.gft.desafio.exercicio3.model;

import java.util.List;

public class Guerreiro extends Personagem {
	
	private List<String> habilidade;

	public Guerreiro() {}

	public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level, List<String> habilidade) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.habilidade = habilidade;
	}

	public List<String> getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(List<String> habilidade) {
		this.habilidade = habilidade;
	}
	
	@Override
	public void lvlUp() {
		super.lvlUp();
		setMana(getMana()+1);
		setInteligencia(getInteligencia()+1);
		setForca(getForca()+3);
		setVida(getVida()+3);
		System.out.printf("O guerreiro %s subiu de nível, o nível atual é %d!\n", getNome(), getLevel());
	}
	
	@Override
	public int attack() {
		int attack;
		attack = ((getForca() * getLevel()) + getRandom(300));
		System.out.printf("O ataque de %s é de %d pontos!\n", getNome(), attack);
		super.attack();
		return attack;
	}
	
	public void aprenderHabilidade(String habilidade) {
		List<String> habilidades = getHabilidade();
		habilidades.add(habilidade);
		System.out.printf("%s aprendeu a habilidade %s!\n", getNome(), habilidade);
		setHabilidade(habilidades);
	}

	@Override
	public String toString() {
		return "-".repeat(120) + "\n"
				+ "Guerreiro "
				+ super.toString()
				+ " - Habilidades: " + habilidade
				+ "\n" + "-".repeat(120);
	}

}
