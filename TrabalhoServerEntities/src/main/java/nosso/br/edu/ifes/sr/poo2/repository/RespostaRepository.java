package nosso.br.edu.ifes.sr.poo2.repository;

import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RespostaRepository extends JpaRepository<RespostaBanco, Long> {

}
