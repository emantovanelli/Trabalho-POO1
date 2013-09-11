package br.edu.ifes.sr.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.service.JogadorService;

public class TestJogador extends AbstractTest {

	@Autowired
	JogadorService service;

	@Test
	public void salvar(){
		
		Jogador jogador = new Jogador();
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());
		
		service.save(jogador);
		Assert.assertNotSame(jogador.getId(), 0);
		
	}
	
	@Test
	public void find(){
		
		Jogador jogador = new Jogador();
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());
		
		service.save(jogador);
		Assert.assertNotSame(jogador.getId(), 0);
		
		Jogador jogadorBanco = service.findByUsername(jogador.getUsername());
		
		Assert.assertSame(jogador.getId(), jogadorBanco.getId());
		
	}
	

	
	
}
