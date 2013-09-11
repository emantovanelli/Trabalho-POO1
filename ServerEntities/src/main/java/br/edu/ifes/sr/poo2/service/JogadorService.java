package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.repository.JogadorRepository;
import br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class JogadorService implements CRUDGenerics<Jogador>
{
	@Autowired
	JogadorRepository repos;

	public void save(Jogador t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public Jogador find(long id) {

		return repos.findOne(id);
	}

	public List<Jogador> findAll() {

		return repos.findAll();
	}
	
	public Jogador findByUsername (String username)
	{
		return repos.findByUsername(username);
	}
	
	public Jogador findByEmail (String email)
	{
		return repos.findByEmail(email);
	}
	

}
