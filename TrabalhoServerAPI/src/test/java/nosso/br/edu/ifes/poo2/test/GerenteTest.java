package nosso.br.edu.ifes.poo2.test;

import java.util.UUID;
import junit.framework.Assert;
import nosso.br.edu.ifes.sr.poo2.api.PerguntaAPI;
import nosso.br.edu.ifes.sr.poo2.api.PerguntaAPIIMpl;
import nosso.br.edu.ifes.sr.poo2.api.model.NivelModel;
import nosso.br.edu.ifes.sr.poo2.api.model.PerguntaModel;
import nosso.br.edu.ifes.sr.poo2.api.model.RespostaModel;

import org.junit.Before;
import org.junit.Test;


public class GerenteTest {
	
	private PerguntaAPI perguntaAPI;
	
	@Before
	public void before(){
		
		UUID.randomUUID().toString();
		perguntaAPI = new PerguntaAPIIMpl();
	}
	
	
	@Test
	public void cadastrarPergunta() throws Exception	{
		PerguntaModel pergunta = new PerguntaModel();
		pergunta.setNivel(NivelModel.FACIL);
		pergunta.setPergunta(UUID.randomUUID().toString());
		
		RespostaModel resp1 = new RespostaModel();
		RespostaModel resp2 = new RespostaModel();
		RespostaModel resp3 = new RespostaModel();
		
		resp1.setFrase(UUID.randomUUID().toString());
		resp2.setFrase(UUID.randomUUID().toString());
		
		resp3.setFrase(UUID.randomUUID().toString());
		
		resp1.setOpcaoCorreta(false);
		resp2.setOpcaoCorreta(true);
		resp3.setOpcaoCorreta(false);
		
		pergunta.addOpcao(resp1);
		pergunta.addOpcao(resp2);
		pergunta.addOpcao(resp3);
		
		perguntaAPI.adicionar(pergunta);
		Integer idPergunta = pergunta.getId().intValue();
		
		PerguntaModel perguntaX = perguntaAPI.get(idPergunta);
		
		Assert.assertSame(pergunta.getId(), perguntaX.getId());
		
		
	}
	

	

}
