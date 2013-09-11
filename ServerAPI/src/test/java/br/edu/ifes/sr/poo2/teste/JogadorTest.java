package br.edu.ifes.sr.poo2.teste;

import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.JogadorAPI;
import br.edu.ifes.sr.poo2.api.JogadorAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ranking;

public class JogadorTest {

	private JogadorAPI jogadorAPI = new JogadorAPIIMpl();

	private Jogador jogador = new Jogador();

	@Before
	public void before() {
		// Criando o jogador
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha("1234");
		jogador.setUsername("paulo");

	}
	@Test
	public void adicionarJogador() throws Exception
	{
		jogadorAPI.adicionar(jogador);
	}
	
	@Test
	public void loginJogador() throws Exception
	{
		jogadorAPI.adicionar(jogador);
		String userName = jogadorAPI.login(jogador.getEmail(), jogador.getSenha());
		Assert.assertNotNull(userName);
	}
	
	@Test
	public void getRanking()
	{
		List<Ranking> rankings = jogadorAPI.getRanking();
		
		Assert.assertNotNull(rankings);
		
	}

}
