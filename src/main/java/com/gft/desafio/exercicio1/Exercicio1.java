package com.gft.desafio.exercicio1;

import java.util.ArrayList;
import java.util.List;

import com.gft.desafio.exercicio1.exception.LimiteDoTanqueUltrapassadoException;
import com.gft.desafio.exercicio1.exception.VeiculoDesligadoNaoAceleraException;
import com.gft.desafio.exercicio1.exception.VeiculoEmMovimentoNaoPodeSerDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaDesligadoException;
import com.gft.desafio.exercicio1.exception.VeiculoJaEstaLigadoException;
import com.gft.desafio.exercicio1.exception.VeiculoParadoNaoFreiaException;
import com.gft.desafio.exercicio1.model.Veiculo;

public class Exercicio1 {
	public static void main(String[] args) {
		Veiculo veiculoUsado = new Veiculo("Volkswagen", "Gol", "ABC1D234", "Prata", 250.0f, true, 45, 99, 35000.00);
		Veiculo veiculoNovo = new Veiculo("Ford", "Focus", "EFG5H678", "Vermelho", 70000.00);
		
		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(veiculoUsado);
		veiculos.add(veiculoNovo);
		
		imprimeStatus(veiculos);
		
		System.out.println("-> ACELERANDO os veículos...");
		veiculos.forEach(v -> {
			try {
				v.acelerar();
			} catch (VeiculoDesligadoNaoAceleraException e) {
				System.out.println(e.getMessage());
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);
		
		System.out.println("-> ABASTECENDO veículos...");
		veiculos.forEach(v -> {
			try {
				v.abastecer(35);
			}	catch (LimiteDoTanqueUltrapassadoException e) {
				System.out.println(e.getMessage());
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);
		
		System.out.println("-> FREANDO veículos...");
		veiculos.forEach(v -> {
			try {
				v.frear();
			} catch (VeiculoParadoNaoFreiaException e) {
				System.out.println(e.getMessage());
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);
		
		System.out.println("-> PINTANDO os veículos...");
		veiculos.forEach(v -> {
			try {
				v.pintar("ROSA");
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);
		
		System.out.println("-> LIGANDO os veículos...");
		veiculos.forEach(v -> {
			try {
				v.ligar();
			}	catch (VeiculoJaEstaLigadoException e) {
				System.out.println(e.getMessage());
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);
		
		System.out.println("-> DESLIGANDO os veículos...");
		veiculos.forEach(v -> {
  		try {
  			v.desligar();
  		}	catch (VeiculoJaEstaDesligadoException | VeiculoEmMovimentoNaoPodeSerDesligadoException  e) {
  			System.out.println(e.getMessage());
  		}	catch (Exception e) {
  			System.out.println(e.getMessage());
  		} 
		});
		imprimeStatus(veiculos);		
		
		System.out.println("-> FREANDO e DESLIGANDO veículos que ainda estavam em movimento...");
		veiculos.forEach(v -> {
			try {
				while (v.getVelocidade() > 0) v.frear();
				v.desligar();
			} catch (VeiculoParadoNaoFreiaException 
								| VeiculoJaEstaDesligadoException
								| VeiculoEmMovimentoNaoPodeSerDesligadoException e) {
				System.out.println(e.getMessage());
			}	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		imprimeStatus(veiculos);

	}
	
	public static void imprimeStatus(List<Veiculo> veiculos) {
		System.out.println("-".repeat(100));
		System.out.println("Status dos veículo(s):");
		try {
			for (Veiculo veiculo : veiculos) {
				System.out.println(veiculo);
			}
		}	catch (Exception e) {
			System.out.println(e.getMessage());
		}	finally {
			System.out.println("-".repeat(100));
		}
	}

}
