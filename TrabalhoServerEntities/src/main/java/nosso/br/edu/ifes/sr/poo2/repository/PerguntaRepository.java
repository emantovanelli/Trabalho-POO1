package nosso.br.edu.ifes.sr.poo2.repository;

import java.util.ArrayList;

import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PerguntaRepository extends JpaRepository<PerguntaBanco, Long> {

	ArrayList<PerguntaBanco> findByNivel(NivelBanco nivel);

}
