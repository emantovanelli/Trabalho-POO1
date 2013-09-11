package nosso.br.edu.ifes.sr.poo2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nosso.br.edu.ifes.sr.poo2.model.JogadorBanco;

@Repository
@Transactional
public interface JogadorRepository extends JpaRepository<JogadorBanco, Long>{

	JogadorBanco findByUsername(String username);
	
}
