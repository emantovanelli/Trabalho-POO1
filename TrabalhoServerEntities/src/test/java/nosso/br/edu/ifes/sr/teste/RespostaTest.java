package nosso.br.edu.ifes.sr.teste;

import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;
import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;
import nosso.br.edu.ifes.sr.poo2.service.PerguntaService;
import nosso.br.edu.ifes.sr.poo2.service.RespostaService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class RespostaTest extends AbstractTest {

	@Autowired
	PerguntaService servicePergunta;// = new PerguntaService();
	
	@Autowired
	RespostaService serviceResposta;// = new RespostaService();
	
	@Test
	public void save(){
		
		PerguntaBanco pergunta = new PerguntaBanco();
		RespostaBanco resp1 = new RespostaBanco();
		RespostaBanco resp2 = new RespostaBanco();
		RespostaBanco resp3 = new RespostaBanco();
		
		pergunta.setNivel(NivelBanco.FACIL);
		String perg = "O aviao voa?";
		pergunta.setPergunta(perg);

		resp1.setFrase("Sim");
		resp2.setFrase("Nao");
		resp3.setFrase("Talvez");
				
		resp1.setOpcaoCorreta(true);
		resp2.setOpcaoCorreta(false);
		resp3.setOpcaoCorreta(false);
		
		pergunta.addOpcao(resp1);
		pergunta.addOpcao(resp2);
		pergunta.addOpcao(resp3);
		
		servicePergunta.save(pergunta);
		
		serviceResposta.save(resp1);
		serviceResposta.save(resp2);
		serviceResposta.save(resp3);

		Assert.assertNotSame(pergunta.getId(), 0);

		Assert.assertNotSame(resp1.getId(), 0);
		Assert.assertNotSame(resp2.getId(), 0);
		Assert.assertNotSame(resp3.getId(), 0);
	
		
	}
	
	public void buscar(){
		
	}
	
	public void deleteAll(){
		

		
		
		
	}
}
