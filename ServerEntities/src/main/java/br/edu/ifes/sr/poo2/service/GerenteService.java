package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Gerente;
import br.edu.ifes.sr.poo2.repository.GerenteRepository;
import br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class GerenteService implements CRUDGenerics<Gerente>
{
	@Autowired
	GerenteRepository repos;

	public boolean exist(String email)
	{
		Gerente gerente = repos.findByEmail(email);
		
		if (gerente!=null) return true;
		else return false;
		
	}
	
	public Gerente findByEmail (String email)
	{
		return repos.findByEmail(email);
	}
	
	public void save(Gerente t) {
		repos.save(t);
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public Gerente find(long id) {

		return repos.findOne(id);
	}

	public List<Gerente> findAll() {

		return repos.findAll();
	}
	
	

}
