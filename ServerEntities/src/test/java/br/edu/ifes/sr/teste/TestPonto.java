package br.edu.ifes.sr.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.model.Gerente;
import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Ponto;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.service.CategoriaService;
import br.edu.ifes.sr.poo2.service.GerenteService;
import br.edu.ifes.sr.poo2.service.JogadorService;
import br.edu.ifes.sr.poo2.service.PontoService;
import br.edu.ifes.sr.poo2.service.ServicoService;

public class TestPonto extends AbstractTest {

	@Autowired
	JogadorService service;

	@Autowired
	PontoService pontoService;

	@Autowired
	ServicoService servicoService;

	@Autowired
	GerenteService gerenteService;
	
	@Autowired
	CategoriaService categoriaService;
	
	private Jogador jogador = new Jogador();
	
	private Gerente gerente = new Gerente();
	private Servico servico = new Servico();
	private Categoria categoria = new Categoria();
	
	@Before
	public void before() {
		// Salvando o jogador
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha(UUID.randomUUID().toString());
		jogador.setUsername(UUID.randomUUID().toString());
		service.save(jogador);

		// Gerente
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha(UUID.randomUUID().toString());
		gerenteService.save(gerente);
		
		//Salvando Servico
		categoria.setNome(UUID.randomUUID().toString());
		categoriaService.save(categoria);
		
		servico.setUrl("Http://serve1.com.br/nomeservico");
		servico.setCategoria(categoria);
		servicoService.save(servico);
	}

	@Test
	public void salvar() {

		// Salvando o ponto
		Ponto ponto = new Ponto();
		ponto.setJogador(jogador);
		ponto.setServico(servico);
		ponto.setValor(10);
		pontoService.save(ponto);
		Assert.assertNotSame(ponto.getId(), 0);
	}

	@Test
	public void findByUsuario() {

		// Salvando o ponto
		Ponto ponto = new Ponto();
		ponto.setJogador(jogador);
		ponto.setServico(servico);
		ponto.setValor(10);
		pontoService.save(ponto);
		Assert.assertNotSame(ponto.getId(), 0);

		Ponto pontoX = pontoService.findByJogadorId(jogador.getId());
		Assert.assertSame(pontoX.getId(), ponto.getId());

	}
	
	@Test
	public void findByUsuarioServico() {

		// Salvando o ponto
		Ponto ponto = new Ponto();
		ponto.setJogador(jogador);
		ponto.setServico(servico);
		ponto.setValor(10);
		pontoService.save(ponto);
		Assert.assertNotSame(ponto.getId(), 0);

		Ponto pontoX = pontoService.findByJogadorUsernameAndServicoId(jogador.getUsername(), servico.getId());
		Assert.assertSame(pontoX.getId(), ponto.getId());

	}

}
