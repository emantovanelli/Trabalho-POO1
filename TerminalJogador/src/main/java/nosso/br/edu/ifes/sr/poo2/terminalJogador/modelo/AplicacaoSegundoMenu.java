package nosso.br.edu.ifes.sr.poo2.terminalJogador.modelo;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.edu.ifes.sr.poo2.api.JogadorAPIIMpl;
import br.edu.ifes.sr.poo2.api.JogoAPIImpl;
import br.edu.ifes.sr.poo2.api.PontoAPI;
import br.edu.ifes.sr.poo2.api.PontoAPIIMpl;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Pergunta;
import br.edu.ifes.sr.poo2.api.model.Ponto;
import br.edu.ifes.sr.poo2.api.model.Ranking;
import br.edu.ifes.sr.poo2.api.model.Resposta;
import br.edu.ifes.sr.poo2.api.model.Servico;
import br.edu.ifes.sr.poo2.api.model.Nivel;

public class AplicacaoSegundoMenu {


	private void listarGategorias(){
		ServicoAPIIMpl servicoAPI = new ServicoAPIIMpl();
		List<Servico> listaServicos;
		
		listaServicos = servicoAPI.getAll();
		
		System.out.println("Lista de categorias disponiveis");
		for(int i = 0; i < listaServicos.size(); i++){
			Categoria categoria = listaServicos.get(i).getCategoria();
			System.out.println(i+1 + "   " + categoria.getNome());
		}
		
		
	}
	public void jogar(String userName) throws Exception{
		ServicoAPIIMpl servicoAPI = new ServicoAPIIMpl();
		JogoAPIImpl jogoAPI = new JogoAPIImpl();
		
		PontoAPI pontoAPI = new PontoAPIIMpl();
		Ponto ponto = new Ponto();
		
		
		Scanner sc = new Scanner(System.in);
		this.listarGategorias();
		
		List<Servico> listaServicos;
		
		System.out.println("Digite o numero da categoria selecionado: ");
		int categoriaSelecao = sc.nextInt();
		categoriaSelecao -= 1;
		
		listaServicos = servicoAPI.getAll();
		
		Servico servico = listaServicos.get(categoriaSelecao);
		
		
		System.out.println("Selecione o nivel da pergunta");
		System.out.println("1 - FACIL");
		System.out.println("2 - MEDIA");
		System.out.println("3 - DIFICIL");
		System.out.println("4 - MIX");
		int opcaoNivel = sc.nextInt();
		
		
		Jogo jogoRecebido;
		if(opcaoNivel == 1){
			jogoRecebido = jogoAPI.jogar(userName, servico.getUrl(), Nivel.FACIL);
		}
		else{
			if(opcaoNivel == 2){
				jogoRecebido = jogoAPI.jogar(userName, servico.getUrl(), Nivel.MEDIO);
			}
			else{
				if(opcaoNivel == 3){
					
					jogoRecebido = jogoAPI.jogar(userName, servico.getUrl(), Nivel.DIFICIL);
				}
				else{
					jogoRecebido = jogoAPI.jogar(userName, servico.getUrl(), Nivel.MIX);
				}
				
			}
		}
		
		Jogo jogoResposta = new Jogo();
		
		// vai percorrendo as perguntas do jogo e adicionando-as ao jogo com as respostas
		for(int cont = 0; cont < jogoRecebido.getPerguntas().size(); cont++){
			System.out.println("Pergunta " + (cont+1));
			Pergunta pergunta = jogoRecebido.getPerguntas().get(cont);
			
			Pergunta perguntaResposta = new Pergunta();
			
			perguntaResposta.setId(pergunta.getId());
			perguntaResposta.setValor(pergunta.getValor());
			
			System.out.println(pergunta.getValor());
			
			// vai percorrendo as possiveis respostas da pergunta e adiciona a resposta do jogador ao jogo com respostas
			for(int cont2 = 0; cont2 < pergunta.getRespostas().size(); cont2++){
				Resposta resp = pergunta.getRespostas().get(cont2);
				System.out.println((cont2+1) + " - " + resp.getResposta());
			}
			System.out.println("Digite a sua resposta: ");
			int numeroResposta = sc.nextInt();
			
			Resposta resp2 = pergunta.getRespostas().get(numeroResposta-1);
			
			Resposta respostaUsuario = new Resposta();
			respostaUsuario.setId(resp2.getId());
			respostaUsuario.setResposta(resp2.getResposta());
			
			perguntaResposta.add(respostaUsuario);
			jogoResposta.add(perguntaResposta);
		}
		
		jogoResposta.setUsername(userName);
		jogoResposta.setIdJogo(jogoRecebido.getIdJogo());
		
		
	
		int pontuacao = jogoAPI.salvarJogo(servico.getUrl(), jogoResposta);
		

		Long pontuacaoJogador = pontoAPI.getPonto(userName, servico.getId());
		Integer pontucacaoIntJogador = pontuacaoJogador.intValue();
		pontuacaoJogador += pontuacao;
		ponto.setIdServico(servico.getId());
		ponto.setUserName(userName);
		ponto.setValor(pontucacaoIntJogador);

		

		System.out.println("Jogador a sua pontuacao foi de " + pontuacao + " ponto(s)");
		pontoAPI.setPonto(ponto);
	}
	
	public void verRanking(){
		JogadorAPIIMpl jogardoAPI = new JogadorAPIIMpl();
		
		List<Ranking> listaRanking;
		
		listaRanking = jogardoAPI.getRanking();
		
		System.out.println("Jogador" + "  " + "Pontuacao");
		
		// Collections.sort(listaRanking);
		
		for(int i = 0; i < listaRanking.size(); i++){
			Ranking rank = listaRanking.get(i);
			System.out.println(rank.getUsername()+ "  " + rank.getValor());
		}
		
	}
	
}
