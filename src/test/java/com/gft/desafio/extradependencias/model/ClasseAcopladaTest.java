package com.gft.desafio.extradependencias.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gft.desafio.extradependencias.exception.NaoPermiteRecursividadeException;

public class ClasseAcopladaTest {
	
	private ClasseAcoplada principal, dependencia, subdependencia;
	
	@Before
	public void setup() {
  	principal = new ClasseAcoplada("Principal");
  	dependencia = new ClasseAcoplada("dependencia");
  	subdependencia = new ClasseAcoplada("subdependencia");
  	
  	principal.adicionaDependente(dependencia);
  	dependencia.adicionaDependente(subdependencia);
	}
	
	@Test
	public void deveCriarClasseAclopadaSomenteComNome_ADependenciaEPaiFicamVaziasAutomaticamente() throws Exception {
		ClasseAcoplada classeAclopada = new ClasseAcoplada("Teste");
		
		assertTrue(classeAclopada.getDependencias().isEmpty());
		assertTrue(classeAclopada.getAscendentes().isEmpty());
	}
	
	@Test
	public void deveExistirOObjetoDependenciaComoDependenciaNoObjetoPrincipal() throws Exception {
		assertThat(principal.getDependencias(), hasItem(dependencia));
	}
	
	@Test
	public void deveExistirOObjetoPrincipalComoAscendenteDoObjetoDependencia() throws Exception {
		assertThat(dependencia.verificaAscencao(), hasItem(principal));
	}
	
	@Test
	public void deveExistirOObjetoPrincipalComoAscendenteDoObjetoSubdependencia() throws Exception {
		assertThat(subdependencia.verificaAscencao(), hasItem(principal));
	}
	
	@Test
	public void devePegarTodaACadeiaDeDependenciasESubdenpendencias() throws Exception {
		
		ClasseAcoplada subdependencia2 = new ClasseAcoplada("subdependencia2");
		ClasseAcoplada subdependencia3 = new ClasseAcoplada("subdependencia3");
		
		dependencia.adicionaDependente(subdependencia2);
		
		subdependencia.adicionaDependente(subdependencia3);
		
		assertThat(principal.getTodasDependenciasESubdependencias(),
										hasItems(dependencia,subdependencia,subdependencia2,subdependencia3));
	}
	
	@Test(expected = NaoPermiteRecursividadeException.class)
	public void naoDevePermitirRecursividade_QuandoTentaAdicionarUmaClasseQueJahEhAscendenteComoDependente() throws Exception {
		dependencia.adicionaDependente(principal);
	}


}
