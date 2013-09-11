package br.edu.ifes.sr.teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.service.CategoriaService;
import br.edu.ifes.sr.poo2.service.ServicoService;

public class ServicoTest extends AbstractTest{
	
	@Autowired
	ServicoService service;
	
	@Autowired
	CategoriaService categoriaService;
	
	private Servico servico;
	
	@Before
	public void before(){
		
		servico = new Servico();
		
	}
	
	@Test
	public void criarServico()
	{
		servico.setUrl("Http://serve1.com.br/nomeservico");
		service.save(servico);
		Assert.assertNotSame(0, servico.getId());
		
	}
	
	@Test
	public void adicionarCategoria()
	{
		servico.setUrl("Http://serve1.com.br/rest/x");
		service.save(servico);
		
		servico = service.find(servico.getId());
		
		//Salvando uma categoria 
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria X");
		categoriaService.save(categoria);
		
		//Somente pode adicionar uma categoria que ja foi salva
		servico.setCategoria(categoria);		
		
		//Salvando o servico com a categoria
		service.save(servico);
		
		//Testando
		servico = service.find(servico.getId());
		Assert.assertSame(servico.getCategoria().getId(),categoria.getId());
	}

}
