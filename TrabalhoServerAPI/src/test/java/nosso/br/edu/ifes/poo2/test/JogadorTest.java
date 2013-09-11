package nosso.br.edu.ifes.poo2.test;


import java.util.Random;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


import br.edu.ifes.sr.poo2.api.JogoAPI;
import br.edu.ifes.sr.poo2.api.JogoAPIImpl;
import br.edu.ifes.sr.poo2.api.ServicoAPI;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;
import br.edu.ifes.sr.poo2.api.model.Pergunta;
import br.edu.ifes.sr.poo2.api.model.Resposta;
import br.edu.ifes.sr.poo2.api.model.Servico;

public class JogadorTest {

	private JogoAPI jogar;

	private Jogador jogador;
	
	private Servico servico;
	
	private ServicoAPI servicoAPI;
	
	private Jogo respostas;
	
	//@Before
	public void before(){
		jogar = new JogoAPIImpl();
		jogador = new Jogador();
		servicoAPI = new ServicoAPIIMpl();
		servico = new Servico();
		respostas = new Jogo();
	}
	
	//@Test
	public void testarJogo() throws Exception{

		
		jogador.setUsername("Nome dele");
		servico = servicoAPI.get(0);
		
		Jogo jogo = jogar.jogar(jogador.getUsername(), servico.getUrl(), Nivel.FACIL);
		
	
		Assert.assertNotNull(jogo);
	}
	
	//@Test
	public void resposderJogo() throws Exception{
		Random random = new Random();
		
		servico = servicoAPI.get(0);
		
		Jogo jogo = jogar.jogar(jogador.getUsername(), servico.getUrl(), Nivel.FACIL);
		
		for(int i = 0; i < jogo.getPerguntas().size(); i++){
			
			Pergunta perg = jogo.getPerguntas().get(i);
			Pergunta pergunta = new Pergunta();
			
			pergunta.setId(perg.getId());
			pergunta.setValor(perg.getValor());
			
			int resposta = random.nextInt(2);
			Resposta resp = perg.getRespostas().get(resposta);
			pergunta.add(resp);			
			respostas.add(pergunta);
		}
		
		int i = jogar.salvarJogo(servico.getUrl(), respostas);
		Assert.assertNotNull(i);
	}

}
