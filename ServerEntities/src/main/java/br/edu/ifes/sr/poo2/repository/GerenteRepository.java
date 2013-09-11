package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Gerente;

@Repository
@Transactional
public interface GerenteRepository extends JpaRepository<Gerente, Long>{

	Gerente findByEmail(String email);
}
