package nosso.br.edu.ifes.sr.poo2.repository;

import nosso.br.edu.ifes.sr.poo2.model.JogoBanco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<JogoBanco, Long> {

}
