package br.edu.ifes.sr.poo2.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.controller.model.Ranking;
import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Ponto;
import br.edu.ifes.sr.poo2.service.JogadorService;



@Controller
@RequestMapping("/jogador")
public class JogadorController extends AbstractController {

	@Autowired
	private JogadorService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody Jogador jogador) {
		try {

				Jogador jogadorX = service.findByEmail(jogador.getEmail());
				//Gerente não existe		
				if (jogadorX == null){
					
					service.save(jogador);
					
					return new ResponseEntity<String>(jogador.getId().toString(),
							HttpStatus.OK);
				}
				//Jogador Existe
				else{
					
					return new ResponseEntity<String>("-1",
							HttpStatus.OK);
					
				}
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Jogador jogador) {
			String resposta = "";
		try {
				
				Jogador jogadorBD = service.findByEmail(jogador.getEmail());

				//Verificando se o jogador existe
				if ((jogadorBD!=null) && (jogadorBD.getSenha().equals(jogador.getSenha())))
				{
					resposta = jogadorBD.getUsername();
				}
				
				return new ResponseEntity<String>(resposta,
						HttpStatus.OK);
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// Retornando um lista de jogadores
	@RequestMapping(value = "/getranking", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Ranking>> get() {
		try {
			//Criando a lista de jogadores
			List<Ranking> ranking = new ArrayList<Ranking>();
			
			List<Jogador> jogadores = service.findAll();
			
			long pontosTotal = 0;
			
			Ranking rankingJogador;
			
			for (Jogador jogador: jogadores)
			{
				pontosTotal = 0;
				
				rankingJogador = new Ranking();
				
				rankingJogador.setUsername(jogador.getUsername());
				
				//Adicionando o raking do jogador no jogo
				ranking.add(rankingJogador);
				
				Iterator<Ponto> pontos = jogador.getPontos().iterator();
				
				while (pontos.hasNext())
				{
					Ponto ponto= pontos.next();
					
					pontosTotal+=ponto.getValor();
				}
				//Adicionando 
				rankingJogador.setValor(pontosTotal);
			}
			return new ResponseEntity<List<Ranking>>(ranking, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Ranking>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
}
