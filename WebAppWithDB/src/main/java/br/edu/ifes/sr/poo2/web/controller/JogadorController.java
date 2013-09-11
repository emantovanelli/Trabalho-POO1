package br.edu.ifes.sr.poo2.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javassist.bytecode.Descriptor.Iterator;

import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;
import nosso.br.edu.ifes.sr.poo2.model.JogoBanco;
import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;
import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;
import nosso.br.edu.ifes.sr.poo2.service.GerenciaService;
import nosso.br.edu.ifes.sr.poo2.service.JogoService;
import nosso.br.edu.ifes.sr.poo2.service.PerguntaService;
import nosso.br.edu.ifes.sr.poo2.service.RespostaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.api.PontoAPI;
import br.edu.ifes.sr.poo2.api.PontoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;
import br.edu.ifes.sr.poo2.api.model.Pergunta;
import br.edu.ifes.sr.poo2.api.model.Ponto;
import br.edu.ifes.sr.poo2.api.model.Resposta;


@Controller
@RequestMapping("/jogar")
public class JogadorController extends AbstractController {
	
	@Autowired
	private PerguntaService servicePergunta;

	@Autowired
	private GerenciaService serviceGerencia;
	
	@Autowired
	private JogoService serviceJogo;
	
	@Autowired
	private RespostaService serviceResposta;
	
	@RequestMapping(value = "/partida/{userName}/{nivel}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Jogo> getPartida(@PathVariable String userName, @PathVariable String nivel)
	{
		try
		{

			NivelBanco nivelMeu;
			
			if(nivel.equals("FACIL"))
			{
				nivelMeu = NivelBanco.FACIL;
			}
			else if(nivel.equals("MEDIO"))
			{
				nivelMeu = NivelBanco.MEDIO;
			}
			else if(nivel.equals("DIFICIL"))
			{
				nivelMeu = NivelBanco.DIFICIL;
			}
			else
			{
				nivelMeu = NivelBanco.MIX;
			}			
			
			
			// adiciona a lista as perguntas ja selecionadas
			ArrayList<PerguntaBanco> listaPerguntaNossa = this.selecionarNossasPerguntas(nivelMeu);
			
			// transforma pro modelo do professor as perguntas selecionadas
			ArrayList<Pergunta> listaPerguntaProfessor = this.tranformarPerguntas(listaPerguntaNossa);

			
			// cria o jogo a adiciona a ele o usuario e a lista de perguntas
			Jogo jogo = new Jogo();
			jogo.setUsername(userName);
			jogo.setPerguntas(listaPerguntaProfessor);
			
			
			// cria o hashset de perguntas pra ser adicionada ao jogo que sera salvo no banco
			HashSet<PerguntaBanco> listaSalvarNoBanco = new HashSet<PerguntaBanco>();

			for(int cont = 0; cont < listaPerguntaNossa.size(); cont++){
				PerguntaBanco perguntaBanco = listaPerguntaNossa.get(cont);
				listaSalvarNoBanco.add(perguntaBanco);
			}
			
			
			JogoBanco jogoBanco = new JogoBanco();
			jogoBanco.setUserName(userName);
			jogoBanco.setListaPerguntas(listaSalvarNoBanco);
			serviceJogo.save(jogoBanco);
			
			
			Long idBanco = jogoBanco.getId();
			
			// setando o id do jogo salvo no banco para o jogo que sera enviado
			jogo.setIdJogo(idBanco.intValue());
			

			return new ResponseEntity<Jogo>(jogo, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<Jogo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	private ArrayList<PerguntaBanco> selecionarNossasPerguntas(NivelBanco nivel){

		ArrayList<PerguntaBanco> listaCompletaPerguntas;
		
		// se o nivel for mix são selecionadas todas as perguntas do banco
		if(nivel == NivelBanco.MIX){
			listaCompletaPerguntas = (ArrayList<PerguntaBanco>) servicePergunta.findAll();
		}
		
		// caso nao seja sao selecionadas as perguntas por nivel
		else{
			listaCompletaPerguntas = servicePergunta.findByNivel(nivel);
		}

		ArrayList<PerguntaBanco> listaPerguntasFiltradas = new ArrayList<PerguntaBanco>();
		Random random = new Random();
		
		// adiciona de forma randomica as perguntas de um jogo
		for(int cont = 0; cont < 5; cont++){
			int valor = random.nextInt(listaCompletaPerguntas.size()-1);
			PerguntaBanco pergunta = listaCompletaPerguntas.remove(valor);
			listaPerguntasFiltradas.add(pergunta);			
		}
		
		return listaPerguntasFiltradas;

	}
	
	public ArrayList<Pergunta> tranformarPerguntas (ArrayList<PerguntaBanco> listaPerguntaNossa){

		
		ArrayList<Pergunta> listaPerguntaProfessor = new ArrayList<Pergunta>();
		
		for(int cont = 0; cont < listaPerguntaNossa.size(); cont++){
			// pegou uma pergunta na posicao cont no array de pergunta do nosso modelo
			PerguntaBanco perguntaNossa = listaPerguntaNossa.get(cont);
			
			
			// tranformou o id para inteiro
			Integer id = perguntaNossa.getId().intValue();
			
			// criou uma pergunta do modelo do professor e setou os valores do id e da pergunta
			Pergunta perguntaProfessor = new Pergunta();
			perguntaProfessor.setId(id);
			perguntaProfessor.setValor(perguntaNossa.getPergunta());
			

			
			// tranformando as respostas e as adiconando na pergunta do modelo do professor
			for(RespostaBanco respNossa : perguntaNossa.getOpcoes()){
			
				Resposta respostaProfessor = new Resposta();
				

				respostaProfessor.setResposta(respNossa.getOpcao());
				Integer idResp = respNossa.getId().intValue();
				respostaProfessor.setId(idResp);
				
				perguntaProfessor.add(respostaProfessor);

			}
			
			listaPerguntaProfessor.add(perguntaProfessor);
		}

		return listaPerguntaProfessor;
	}
	
	
	
	

	@RequestMapping(value = "/responder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> respostaJogador(@RequestBody Jogo jogoProfessor){
		try{
		
			ArrayList<Pergunta> perguntaModeloProfessor = (ArrayList<Pergunta>) jogoProfessor.getPerguntas();
			
			// faz o calculo da pontuacao
			int pontuacao = this.calculaPontuacao(perguntaModeloProfessor);
			

			Integer pontuacaoFinal = pontuacao;
			

			// busca o jogo do tipo do meu banco e salva a atualizacao da pontuacao
			Integer jogoID = jogoProfessor.getIdJogo();
			Long longIDJogo = jogoID.longValue();
			JogoBanco jogo = serviceJogo.find(longIDJogo);
			jogo.setPontuacao(pontuacaoFinal);
			serviceJogo.save(jogo);
			
			// retorna a pontuacao final
			return new ResponseEntity<Integer>(pontuacaoFinal, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public int calculaPontuacao(ArrayList<Pergunta> perguntasModeloPrfessor){
		

		int pontuacao = 0;
		
		RespostaBanco respNosso;
		PerguntaBanco perguntaNosso;
		
		Pergunta perguntaProfessor;
		Resposta respostaProfessor;
		

		// percorre a as perguntas do professor pegando as respostas na posicao 0
		for(int cont = 0; cont < perguntasModeloPrfessor.size(); cont++){
			
			perguntaProfessor = perguntasModeloPrfessor.get(cont);

			
			// busca a pergunta no banco pelo id
			Integer idPerguntaInt = perguntaProfessor.getId();
			perguntaNosso = servicePergunta.find(idPerguntaInt.longValue());
			
			
			// busca a reposta no banco pelo id
			respostaProfessor = perguntasModeloPrfessor.get(cont).getRespostas().get(0);
			Integer idInteiroResposta = respostaProfessor.getId();
			Long idResposta = idInteiroResposta.longValue();
			respNosso = serviceResposta.find(idResposta);
			
			
			// se a resposta for a certa e adicionado a pontuacao o valor de cada pergunta
			if(respNosso.isOpcaoCorreta()){
				pontuacao += perguntaNosso.getNivel().getValor();
			}
		}

		return pontuacao;
			
		}
	
	
	
	
	
	
	
	
}
