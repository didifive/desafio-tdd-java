package com.gft.desafio.main;

import java.util.InputMismatchException;
import java.util.Scanner;


import com.gft.desafio.exercicio1.Exercicio1;
import com.gft.desafio.exercicio2.Exercicio2;
import com.gft.desafio.exercicio3.Exercicio3;
import com.gft.desafio.exercicio7.Exercicio7;
import com.gft.desafio.extradependencias.DependenciasTransitivas;
import com.gft.desafio.extrajokenpo.Jokenpo;

public class DesafioTDDApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		menu(sc);
		
		sc.close();
		
		System.out.println("=".repeat(100));
		System.out.printf("Programa encerrado!");
	}

	private static void menu(Scanner sc) {
		boolean inicio;
		do {
			inicio = false;
			System.out.println("=".repeat(100));
			System.out.println("LISTA DE EXERCÍCIOS DESAFIO TDD");
			for (int i=1; i<=9; i++) {
				if (i == 1 || i == 2 || i == 3 || i == 7) {
	  				System.out.printf("%d- Exercício %d\n",i,i);
				} else if (i == 4 || i == 5 || i == 6) {
					continue;
				} else if (i == 8) {
					System.out.printf("%d- Desafio Extra - Jokenpo\n",i);
				} else if (i == 9) {
					System.out.printf("%d- Desafio Extra - Dependencias Transitivas\n",i);
				}
			}
			System.out.println("0- Encerrar");
			menuOpcoes(sc);
			inicio = reiniciar(sc, inicio);
		} while (inicio);
	}
	
	private static void menuOpcoes(Scanner sc) {
		int exercicio;
		boolean voltaOpcoes;
		do {
			voltaOpcoes = false;
			String[] args = {"Foi chamado pela main Desafio TDD"};
			
			System.out.print("Por favor, digite o número da opção que deseja executar: ");
			try {
				exercicio = sc.nextInt();
				switch (exercicio) {
				case 0:
					System.out.println("=".repeat(100));
					System.out.println("===== ENCERRAR PROGRAMA =====");
					break;
				case 1:
					execucaoCabecalho(exercicio);
					Exercicio1.main(null);
					execucaoRodape(exercicio);
					break;
				case 2:
					execucaoCabecalho(exercicio);
					Exercicio2.main(null);
					execucaoRodape(exercicio);
					break;
				case 3:
					execucaoCabecalho(exercicio);
					Exercicio3.main(null);
					execucaoRodape(exercicio);
					break;
				case 7:
					execucaoCabecalho(exercicio);
					Exercicio7.main(null);
					execucaoRodape(exercicio);
					break;
				case 8:
					System.out.println("=".repeat(100));
					System.out.println("======  JOKENPO  ======");
					Jokenpo.main(args);
					sc.reset();
					System.out.println("=".repeat(100));
					System.out.println("===== FIM JOKENPO =====");
					break;
				case 9:
					System.out.println("=".repeat(100));
  				System.out.println("===== DEPENDENCIAS TRANSITIVAS =====");
  				DependenciasTransitivas.main(args);
					System.out.println("=".repeat(100));
					System.out.println("=== FIM DEPENDENCIAS TRANSITIVAS ===");
				break;
				default:
					System.out.println("Digite um número válido da lista!");
					voltaOpcoes = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor digite um NÚMERO válido da lista!");
				voltaOpcoes = true;
				sc.next();
			}			
		} while (voltaOpcoes);
	}

	private static void execucaoCabecalho(int exercicio) {
		System.out.println("=".repeat(100));
		System.out.println("===== INÍCIO EXERCÍCIO "+ exercicio +" =====");
	}
	
	private static void execucaoRodape(int exercicio) {
		System.out.println("===== FIM EXERCÍCIO "+ exercicio +" =====");
		System.out.println("=".repeat(100));
	}

	private static boolean reiniciar(Scanner sc, boolean inicio) {
		boolean reinicio;
		String reinicioResposta;
		do {
			reinicio = false;
			System.out.println("=".repeat(100));
			System.out.println("Deseja encerrar o programa?");
			System.out.print("Digite \"S\" para Encerrar ou \"N\" para voltar ao menu de opções: ");
			reinicioResposta = sc.next();
			switch (reinicioResposta) {
				case "N":
				case "n":
					inicio = true;
					break;
				case "S":
				case "s":
					inicio = false;
					break;
				default: 
					System.out.println("Opção inválida!");
					reinicio = true;
			}
		} while (reinicio);
		return inicio;
	}	

}
