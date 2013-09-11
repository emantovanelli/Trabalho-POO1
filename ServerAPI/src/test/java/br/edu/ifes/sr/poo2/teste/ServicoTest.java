package br.edu.ifes.sr.poo2.teste;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.GerenteAPI;
import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.ServicoAPI;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.api.model.Servico;


public class ServicoTest {
	
	private GerenteAPI gerenteAPI;
	
	private ServicoAPI servicoAPI;
	
	@Before
	public void before(){
		
		gerenteAPI = new GerenteAPIIMpl();
		servicoAPI = new ServicoAPIIMpl();
	
	}
	
	@Test
	public void isWorking()
	{
		boolean resposta = servicoAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
		resposta = gerenteAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
	}
	
	@Test
	public void adicionarServico() throws Exception
	{
		Assert.assertNotSame(0, criarServico());
		
	}
	
	private int criarServico() throws Exception 
	{
		Gerente gerente = new Gerente();
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
		
		long idGerente = gerenteAPI.adicionar(gerente);
		
		gerente.setId(idGerente);
		
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria "+UUID.randomUUID().toString());
		categoria.setDescricao("XXXXX");
		
		Servico servicoX = new Servico();
		servicoX.setGerente(gerente);
		servicoX.setCategoria(categoria);
		servicoX.setUrl("http://"+UUID.randomUUID().toString()+"/rest/");
		return servicoAPI.adicionar(servicoX);
	
	}
	
}
