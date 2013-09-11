package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.repository.CategoriaRepository;
import br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class CategoriaService implements CRUDGenerics<Categoria>
{
	@Autowired
	CategoriaRepository repos;

	public void save(Categoria t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public Categoria find(long id) {

		return repos.findOne(id);
	}

	public List<Categoria> findAll() {

		return repos.findAll();
	}
	
	public Categoria findByNome (String nome)
	{
		return repos.findByNome(nome);
	}

}
