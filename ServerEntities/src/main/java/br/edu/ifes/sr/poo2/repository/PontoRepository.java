package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Ponto;

@Repository
@Transactional
public interface PontoRepository extends JpaRepository<Ponto, Long>{

	Ponto findByJogadorId(long id);
	
	Ponto findByJogadorUsername(String username);
	
	Ponto findByJogadorUsernameAndServicoId(String username, long servicoId);
}
