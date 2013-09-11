package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;

public interface JogoAPI {

	public Jogo jogar (String username, String URLServico, Nivel nivel);
	
	public int salvarJogo (String URLServico, Jogo jogo);
	
}
