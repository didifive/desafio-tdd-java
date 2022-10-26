package com.gft.desafio.exercicio3.model;

import java.util.List;

public class Mago extends Personagem {
	
	private List<String> magia;

	public Mago() {}

	public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level, List<String> magia) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.magia = magia;
	}

	public List<String> getMagia() {
		return magia;
	}

	public void setMagia(List<String> magia) {
		this.magia = magia;
	}

	@Override
	public void lvlUp() {
		super.lvlUp();
		setMana(getMana()+3);
		setInteligencia(getInteligencia()+3);
		setForca(getForca()+1);
		setVida(getVida()+1);
		System.out.printf("O mago %s subiu de nível, o nível atual é %d!\n", getNome(), getLevel());
	}
	
	@Override
	public int attack() {
		int attack;
		attack = (getInteligencia() * getLevel()) + getRandom(300);
		System.out.printf("O ataque de %s é de %d pontos!\n", getNome(), attack);
		super.attack();
		return attack;
	}

	public void aprenderMagia(String magia) {
		List<String> magias = getMagia();
		magias.add(magia);
		System.out.printf("%s aprendeu a magia %s!\n", getNome(), magia);
		setMagia(magias);
	}
	
	@Override
	public String toString() {
		return "-".repeat(120) + "\n"
				+ "Mago "
				+ super.toString()
				+ " - Magias: " + magia
				+ "\n" + "-".repeat(120);
	}

}
