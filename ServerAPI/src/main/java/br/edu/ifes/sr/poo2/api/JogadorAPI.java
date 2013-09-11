package br.edu.ifes.sr.poo2.api;

import java.util.List;

import br.edu.ifes.sr.poo2.api.generic.API;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ranking;

public interface JogadorAPI extends API<Jogador> {
	
	public String login(String email, String senha) throws Exception;
	
	public List<Ranking> getRanking();
	
}
