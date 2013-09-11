package br.edu.ifes.sr.teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.service.CategoriaService;

public class TestCategoria extends AbstractTest {

	@Autowired
	CategoriaService service;

	@Test
	public void salvar(){
		
		Categoria categoria = new Categoria();
		categoria.setNome("Musica");
		categoria.setDescricao("Categorias sobre questao de musica");
		service.save(categoria);
		Assert.assertNotSame(categoria.getId(), 0);
		
	}
	
	@Test
	public void find(){
		
		Categoria categoria = new Categoria();
		categoria.setNome("Musica");
		categoria.setDescricao("Categorias sobre questao de musica");
		service.save(categoria);
		Assert.assertNotSame(categoria.getId(), 0);
		
		List<Categoria> categorias = service.findAll();
		
		Assert.assertNotNull(categorias);
		
	}
	
	
}
