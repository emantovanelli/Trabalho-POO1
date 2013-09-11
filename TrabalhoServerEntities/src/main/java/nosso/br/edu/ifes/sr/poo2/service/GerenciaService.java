package nosso.br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;
import nosso.br.edu.ifes.sr.poo2.repository.GerenciaRepository;
import nosso.br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;

@Service
public class GerenciaService implements CRUDGenerics<GerenciaBanco> {
	
	@Autowired
	GerenciaRepository repos;
	
	public void save(GerenciaBanco t) {
		// TODO Auto-generated method stub
		repos.save(t);
	}

	public void delete(long id) {
		repos.delete(id);
	}

	public GerenciaBanco find(long id) {
		// TODO Auto-generated method stub
		return repos.findOne(id);
	}

	public List<GerenciaBanco> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

}
