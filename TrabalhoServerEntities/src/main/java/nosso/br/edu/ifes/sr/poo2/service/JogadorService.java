package nosso.br.edu.ifes.sr.poo2.service;

import java.util.List;

import nosso.br.edu.ifes.sr.poo2.model.JogadorBanco;
import nosso.br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

import nosso.br.edu.ifes.sr.poo2.repository.JogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements CRUDGenerics<JogadorBanco>
{
	@Autowired
	JogadorRepository repos;

	public void save(JogadorBanco t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public JogadorBanco find(long id) {

		return repos.findOne(id);
	}

	public List<JogadorBanco> findAll() {

		return repos.findAll();
	}
	
	public JogadorBanco findByUsername (String username)
	{
		return repos.findByUsername(username);
	}

	

}
