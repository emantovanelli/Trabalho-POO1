package nosso.br.edu.ifes.sr.teste;

import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;
import nosso.br.edu.ifes.sr.poo2.service.PerguntaService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PerguntaTest extends AbstractTest {
	@Autowired
	PerguntaService servicePergunta;
	
	
	
	@Test
	public void save(){
		PerguntaBanco pergunta = new PerguntaBanco();
		pergunta.setNivel(NivelBanco.FACIL);
		String perg = "O aviao voa?";
		pergunta.setPergunta(perg);
		
		servicePergunta.save(pergunta);
		Assert.assertNotSame(pergunta.getId(), 0);
		
		servicePergunta.delete(pergunta.getId());
	}
	
	public void find(){
		PerguntaBanco pergunta = new PerguntaBanco();
		pergunta.setNivel(NivelBanco.FACIL);
		String perg = "O aviao voa?";
		pergunta.setPergunta(perg);
		
		servicePergunta.save(pergunta);
		Assert.assertNotSame(pergunta.getId(), 0);
		
		PerguntaBanco perg2 = servicePergunta.find(pergunta.getId());
		Assert.assertSame(perg2.getId(), pergunta.getId());
		
		servicePergunta.delete(pergunta.getId());
	}
	
}
