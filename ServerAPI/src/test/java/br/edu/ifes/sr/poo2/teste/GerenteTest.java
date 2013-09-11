package br.edu.ifes.sr.poo2.teste;

import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.GerenteAPI;
import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Gerente;

public class GerenteTest {
	
	private GerenteAPI exampleAPI;
	private Gerente gerente;
	
	@Before
	public void before(){
		
		exampleAPI = new GerenteAPIIMpl();
		gerente = new Gerente();
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
	}
	
	
	@Test
	public void isWorking()
	{
		boolean resposta = exampleAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
	}
	
	@Test
	public void adicionarGerente() throws Exception
	{
		
		int id = exampleAPI.adicionar(gerente);
		Assert.assertNotSame(0, id);
		
		
	}
	
	@Test
	public void getGerente() throws Exception
	{
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
		
		int id = exampleAPI.adicionar(gerente);
		
		Gerente usuarioX = exampleAPI.get(id);
		
		
	}
	
	
	@Test
	public void login()
	{
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
		
		Boolean valor = exampleAPI.login(gerente.getEmail(), gerente.getSenha());
		
		Boolean esperado = false;
		
		Assert.assertEquals(esperado, valor);
		
	}
	
	@Test
	public void getListGerente() throws Exception
	{
		List<Gerente> gerentes = exampleAPI.getAll();
		Assert.assertNotNull(gerentes);
		
	}

}
