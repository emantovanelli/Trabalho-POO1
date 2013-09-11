package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.util.List;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ranking;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class JogadorAPIIMpl extends APIGeneric implements JogadorAPI{
	
	public JogadorAPIIMpl()
	{
		URL +="/jogador";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}


	public List<Jogador> getAll() {
		
		return null;
		
	}

	public int adicionar(Jogador t) throws Exception {
		
		String JSON = gson.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add/", JSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}
	
	public Jogador get(int i) throws Exception{
		throw new Exception("NotImplemented");
	}

	public String login(String email, String senha) throws Exception{
		
		Jogador jogador = new Jogador();
		
		jogador.setEmail(email);
		jogador.setSenha(senha);
		
		String JSON = gson.toJson(jogador);
		
		ClientResponse response = clientAPIUtil.post(URL+"/login/", JSON);
		
		String retorno = response.getEntity(String.class);
		
		if (retorno.trim().isEmpty()) throw new Exception("USERNOTEXIST");
		
		return retorno.trim();
	}

	public List<Ranking> getRanking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/getranking");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayList = new TypeToken <List<Ranking>>(){}.getType();
		
		List<Ranking> ranking = gson.fromJson(jsonResposta, arrayList);
		
		return ranking;
	}
	
	
	
	

	

}
