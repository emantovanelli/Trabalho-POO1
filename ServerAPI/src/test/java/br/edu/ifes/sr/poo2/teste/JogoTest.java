package br.edu.ifes.sr.poo2.teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.poo2.api.JogoAPI;
import br.edu.ifes.sr.poo2.api.JogoAPIImpl;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;
import br.edu.ifes.sr.poo2.api.model.Pergunta;
import br.edu.ifes.sr.poo2.api.model.Resposta;

public class JogoTest {

	private JogoAPI jogoAPI;
	private String URL;
	private String userName;
	
	@Before
	public void before()
	{
		jogoAPI = new JogoAPIImpl();
		URL = "http://localhost:8080/jogows/rest/";
		userName = "paulossjunior";
	}
	
	@Test
	public void partida()
	{
		
		Jogo jogo = jogoAPI.jogar(userName, URL, Nivel.DIFICIL);

		Assert.assertNotNull(jogo);
		//Verificando se o jogo possui perguntas
		Assert.assertNotSame(0, jogo.getPerguntas().size());
		//Verificando se a pergunta possui respostas
		Assert.assertNotSame(0, jogo.getPerguntas().get(0).getRespostas().size());
		
		System.out.println(jogo.getIdJogo());
		System.out.println(jogo.getUsername());
		
		for (Pergunta pergunta: jogo.getPerguntas())
		{
			System.out.println("P: "+pergunta.getValor());
			
			for (Resposta resposta: pergunta.getRespostas())
			{
				System.out.println("R: "+resposta.getResposta());	
			}
			
		}
		System.out.println("---------");
		
	}
	
	@Test
	public void salvarJogo()
	{
		Jogo jogo = jogoAPI.jogar(userName, URL, Nivel.DIFICIL);
		
		Integer pontos = jogoAPI.salvarJogo(URL, jogo);
		
		Assert.assertNotNull(pontos);
	}
	
}
