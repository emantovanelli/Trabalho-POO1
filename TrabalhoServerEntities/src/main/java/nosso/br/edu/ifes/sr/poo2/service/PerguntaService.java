package nosso.br.edu.ifes.sr.poo2.service;

import java.util.ArrayList;
import java.util.List;

import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.repository.PerguntaRepository;
import nosso.br.edu.ifes.sr.poo2.service.generic.CRUDGenerics;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerguntaService implements CRUDGenerics<PerguntaBanco> {

	@Autowired
	PerguntaRepository repos;
	
	public void save(nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco t) {
		System.out.println(t.getPergunta());
		repos.save(t);
		
	}

	public void delete(long id) {
		repos.delete(id);
		
	}

	public nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco find(long id) {
		return repos.findOne(id);
	}

	public List<nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco> findAll() {
		return repos.findAll();
	}
	
	public ArrayList<nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco> findByNivel(NivelBanco nivel){
		return repos.findByNivel(nivel);
	}

}
