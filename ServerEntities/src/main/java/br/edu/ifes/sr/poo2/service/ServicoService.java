package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.repository.ServicoRepository;
import br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class ServicoService implements CRUDGenerics<Servico>
{
	@Autowired
	ServicoRepository repos;

	public void save(Servico t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public Servico find(long id) {

		return repos.findOne(id);
	}

	public List<Servico> findAll() {

		return repos.findAll();
	}
	
	public void adicionarCategoria(Categoria categoria, long id){
		
		Servico servico = this.find(id);
		
		servico.setCategoria(categoria);
		
		repos.save(servico);
		
	}
	
	
	
	
	
	

}
