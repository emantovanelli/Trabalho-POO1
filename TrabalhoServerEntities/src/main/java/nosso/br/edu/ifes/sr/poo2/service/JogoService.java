package nosso.br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nosso.br.edu.ifes.sr.poo2.model.JogoBanco;
import nosso.br.edu.ifes.sr.poo2.repository.JogoRepository;
import nosso.br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class JogoService implements CRUDGenerics<JogoBanco> {
	@Autowired
	JogoRepository repos; 
	
	public void save(JogoBanco t) {
		
		repos.save(t);
	}

	public void delete(long id) {
		
		repos.delete(id);
	}

	public JogoBanco find(long id) {
		
		return repos.findOne(id);
	}

	public List<JogoBanco> findAll() {
		
		return repos.findAll();
	}

}
