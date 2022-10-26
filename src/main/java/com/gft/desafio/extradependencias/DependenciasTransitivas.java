package com.gft.desafio.extradependencias;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.gft.desafio.extradependencias.exception.NaoPermiteRecursividadeException;
import com.gft.desafio.extradependencias.model.ClasseAcoplada;

/**
 * Desafio Extra Dependências Transitivas.
 * 
 * @see https://dojopuzzles.com/problems/dependencias-transitivas/
 */
public class DependenciasTransitivas {
	
	public static void main(String[] args) {
		Scanner scd = new Scanner(System.in);
		Set<ClasseAcoplada> listaDeToken = new TreeSet<>();
		
		cabecalho();
		
		input(scd, listaDeToken);
  	
		resultado(listaDeToken);
		
		if (Objects.isNull(args)) {
			scd.close();
		}
	}

	private static void cabecalho() {
		System.out.println("=".repeat(100));
		System.out.println("Seja Bem-vindo(a) ao programa de Dependencias Transitivas!");
		System.out.println("-".repeat(33) + " INSTRUÇÃO " + "-".repeat(34));
		System.out.println("| Cada linha deve iniciar com o token que representa o objeto pai,           |");
		System.out.println("| seguidos dos tokens que representam os dependentes separados por espaço    |");
		System.out.println("| Exemplo de linha: A B C                                                    |");
		System.out.println("| O 'A' é o token pai, sendo que 'B' e 'C' são seus respectivos dependentes. |");
		System.out.println("|                                                                            |");
		System.out.println("| Para encerrar a entrada, basta apertar 'Enter' com a linha vazia.          |");
		System.out.println("-".repeat(78));
		
		System.out.println("Informe abaixo as linhas com os objetos, observando a instrução acima: ");
	}

	private static void input(Scanner scd, Set<ClasseAcoplada> listaDeToken) {
		boolean continua;
		
		continua = true;
		while(continua) {
			
  		String linhaDigitada =  scd.nextLine();
			if (linhaDigitada.isBlank() || linhaDigitada.isEmpty()) {
  			continua = false;
  			continue;
  		}
			
			String[] linha = linhaDigitada.split(" ");
  		
  		ClasseAcoplada principal = new ClasseAcoplada(linha[0]);
  		principal = verificaSeJaExiste(listaDeToken, principal);
  		
  		listaDeToken.add(principal);
  		
  		for (int i=1;i<linha.length;i++) {
  			try {
  				ClasseAcoplada dependente = new ClasseAcoplada(linha[i]);
  				dependente = verificaSeJaExiste(listaDeToken, dependente);
  				principal.adicionaDependente(dependente);
  			} catch (NaoPermiteRecursividadeException e) {
  				System.out.println(e.getMessage());
  			}
  		}
		}
	}

	private static ClasseAcoplada verificaSeJaExiste(Set<ClasseAcoplada> listaDeToken, ClasseAcoplada classeAcoplada) {
		for (ClasseAcoplada existente : listaDeToken) {
			if (existente.getNome().equals(classeAcoplada.getNome())) {
				classeAcoplada = existente;
			} else {
				for (ClasseAcoplada dependente : existente.getDependencias()) {
					if (dependente.getNome().equals(classeAcoplada.getNome())) {
						classeAcoplada = dependente;
					}
				}
			}
		}
		return classeAcoplada;
	}
	
	private static void resultado(Set<ClasseAcoplada> listaDeToken) {
		System.out.println("-".repeat(100));
		System.out.println("Abaixo está o resultado dos tokens com suas respectivas Dependências Transitivas:");
		listaDeToken.forEach(c -> {
			Set<ClasseAcoplada> principalDependencias = c.getTodasDependenciasESubdependencias();
			
			String joinedString = principalDependencias.stream()
																			.map(ClasseAcoplada::getNome)
																			.collect(Collectors.joining(" "));
			
			System.out.println(c.getNome() + "  " + joinedString);
			
		});
		
		System.out.println("=".repeat(100));
		System.out.println("FIM DO PROGRAMA DEPENDENCIAS TRANSITIVAS");
	}
}
