package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class JogoAPIImpl extends APIGeneric implements JogoAPI  {
	
	public Jogo jogar(String username, String URLServico, Nivel nivel) {

		
		ClientResponse response = clientAPIUtil.get(URLServico+"/jogar/partida/"+username+"/"+nivel);
		
		String jsonJogo = response.getEntity(String.class);
		
		Type jogoType = new TypeToken <Jogo>(){}.getType();
		
		Jogo novoJogo = gson.fromJson(jsonJogo, jogoType);
		
		return novoJogo;
	}

	public int salvarJogo(String URLServico, Jogo jogo) {
		
		
		String JSON = gson.toJson(jogo);
		
		ClientResponse response = clientAPIUtil.post(URLServico+"/jogar/responder/", JSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer pontuacao = new Integer (retorno);
		
		return pontuacao;
		
	}
	
	

}
