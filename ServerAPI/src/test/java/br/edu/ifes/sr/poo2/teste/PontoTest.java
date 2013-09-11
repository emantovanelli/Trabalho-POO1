package br.edu.ifes.sr.poo2.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.GerenteAPI;
import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.JogadorAPI;
import br.edu.ifes.sr.poo2.api.JogadorAPIIMpl;
import br.edu.ifes.sr.poo2.api.PontoAPI;
import br.edu.ifes.sr.poo2.api.PontoAPIIMpl;
import br.edu.ifes.sr.poo2.api.ServicoAPI;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ponto;
import br.edu.ifes.sr.poo2.api.model.Servico;


public class PontoTest {

	private GerenteAPI gerenteAPI;
	
	private JogadorAPI jogadorAPI;
	
	private ServicoAPI servicoAPI;
	
	private PontoAPI pontoAPI;
	
	private Gerente gerente = new Gerente();
	
	private Categoria categoria =  new Categoria();
	
	private Jogador jogador = new Jogador();
	
	private Servico servico = new Servico();
	
	
	@Before
	public void before()
	{
		gerenteAPI = new GerenteAPIIMpl();
		
		jogadorAPI = new JogadorAPIIMpl();
		
		servicoAPI = new ServicoAPIIMpl();
		
		pontoAPI = new PontoAPIIMpl();
		
		//Criando o servico
		servico.setUrl("http://"+UUID.randomUUID().toString());
		
		//Gerente
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha("XXXX");
		
		//Criando a categoria
		categoria.setDescricao(UUID.randomUUID().toString());
		categoria.setNome(UUID.randomUUID().toString());
		
		//Criando o jogador
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());
		
	}
	
	@Test
	public void adicionarponto() throws Exception
	{
		//adicionando o jogador
		jogadorAPI.adicionar(jogador);
		
		//Criando o gerente
		long idGerente = gerenteAPI.adicionar(gerente);
		
		gerente.setId(idGerente);
		
		servico.setCategoria(categoria);
		servico.setGerente(gerente);
		
		//Adicionando o servico
		int idServico = servicoAPI.adicionar(servico);
		
		Assert.assertNotSame(idServico, 0);
		
		Ponto ponto = new Ponto();
		
		ponto.setIdServico(idServico);
		
		ponto.setUserName(jogador.getUsername());
		
		ponto.setValor(10);
		
		//Adicionando o ponto
		pontoAPI.setPonto(ponto);
	}
	
	@Test
	public void getPonto()
	{
		Long ponto = pontoAPI.getPonto("isolino", new Long(34));
		Assert.assertNotNull(ponto);
	}
	
	
}
