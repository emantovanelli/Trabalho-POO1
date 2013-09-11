package nosso.br.edu.ifes.sr.poo2.repository;

import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenciaRepository extends JpaRepository<GerenciaBanco, Long> {

}
