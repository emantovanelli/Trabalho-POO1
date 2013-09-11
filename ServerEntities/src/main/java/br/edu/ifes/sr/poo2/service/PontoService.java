package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Ponto;
import br.edu.ifes.sr.poo2.repository.PontoRepository;
import br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class PontoService implements CRUDGenerics<Ponto>
{
	@Autowired
	PontoRepository repos;

	public void save(Ponto t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public Ponto find(long id) {

		return repos.findOne(id);
	}

	public List<Ponto> findAll() {

		return repos.findAll();
	}
	
	public Ponto findByJogadorId (Long id)
	{
		return repos.findByJogadorId(id);
	}
	
	public Ponto findByJogadorUsername(String username){
		return repos.findByJogadorUsername(username);
	}
	
	public Ponto findByJogadorUsernameAndServicoId(String username, long servicoId){
		return repos.findByJogadorUsernameAndServicoId(username, servicoId);
	}
	
	
	
	

}
