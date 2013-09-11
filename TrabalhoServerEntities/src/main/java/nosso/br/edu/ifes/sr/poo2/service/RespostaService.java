package nosso.br.edu.ifes.sr.poo2.service;

import java.util.List;

import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;
import nosso.br.edu.ifes.sr.poo2.repository.RespostaRepository;
import nosso.br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RespostaService implements CRUDGenerics<RespostaBanco> {
	
	@Autowired
	RespostaRepository repos;

	public void save(RespostaBanco t) {
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public RespostaBanco find(long id) {
		return repos.findOne(id);
	}

	public List<RespostaBanco> findAll() {
		return repos.findAll();
	}

}
