package com.gft.desafio.extradependencias.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import com.gft.desafio.extradependencias.exception.NaoPermiteRecursividadeException;

public class ClasseAcoplada implements Comparable<ClasseAcoplada> {
	
	private String nome;
	private Set<ClasseAcoplada> dependencias;
	private Set<ClasseAcoplada> ascendentes;
	
	public ClasseAcoplada(String nome) {
		this.nome = nome;
		this.dependencias = new TreeSet<>();
		this.ascendentes = new TreeSet<>();
	}
	
	public ClasseAcoplada(String nome, Set<ClasseAcoplada> dependencias, Set<ClasseAcoplada> ascendentes) {
		this.nome = nome;
		this.dependencias = dependencias;
		this.ascendentes = ascendentes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ClasseAcoplada> getDependencias() {
		return dependencias;
	}

	public void setDependencias(Set<ClasseAcoplada> dependencias) {
		this.dependencias = dependencias;
	}
	
	public Set<ClasseAcoplada> getAscendentes() {
		return ascendentes;
	}

	public void setAscendente(Set<ClasseAcoplada> ascendentes) {
		this.ascendentes = ascendentes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ascendentes, dependencias, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClasseAcoplada other = (ClasseAcoplada) obj;
		return Objects.equals(ascendentes, other.ascendentes) && Objects.equals(dependencias, other.dependencias)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(ClasseAcoplada o) {
		return getNome().compareTo(o.getNome());
	}
	
	@Override
	public String toString() {
		return "nome=" + nome + ", dependencias=" + dependencias + "";
	}

	public void adicionaDependente(ClasseAcoplada classeAcoplada) {
		if (verificaAscencao().contains(classeAcoplada)) {
			throw new NaoPermiteRecursividadeException(classeAcoplada.getNome(),getNome());
		}
		getDependencias().add(classeAcoplada);
		classeAcoplada.getAscendentes().add(this);
	}
	
	public Set<ClasseAcoplada> verificaAscencao() {
		Set<ClasseAcoplada> ascencao = new TreeSet<>();
		
		ascencao.addAll(getAscendentes());
		
		for (ClasseAcoplada ascendente : getAscendentes()) {
			ascencao.addAll(ascendente.verificaAscencao());
		}
		
		return ascencao;
	}
	
	public Set<ClasseAcoplada> getTodasDependenciasESubdependencias() {
		Set<ClasseAcoplada> todasDependencias = new TreeSet<>();
		
		todasDependencias.addAll(getDependencias());
		
		for (ClasseAcoplada dependencia : getDependencias()) {
			todasDependencias.addAll(dependencia.getTodasDependenciasESubdependencias());
		}
		
		return todasDependencias;
	}
}
