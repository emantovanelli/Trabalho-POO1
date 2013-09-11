package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Servico;

@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
