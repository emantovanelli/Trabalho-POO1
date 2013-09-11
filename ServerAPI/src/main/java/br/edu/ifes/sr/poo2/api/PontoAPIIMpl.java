package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ponto;

import com.sun.jersey.api.client.ClientResponse;

public class PontoAPIIMpl extends APIGeneric implements PontoAPI{
	
	public PontoAPIIMpl()
	{
		URL +="/ponto";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}

	public Jogador get(int i) throws Exception{
		throw new Exception("NotImplemented");
	}

	public Long getPonto(String username, Long idServico) {
		
		ClientResponse response = clientAPIUtil.get(URL+"/get/"+username+"/"+idServico);
		
		String ponto = response.getEntity(String.class);
		
		Long resp = new Long(ponto.trim());
		
		return resp;
	}

	public void setPonto(Ponto ponto) throws Exception {
		
		String JSON = gson.toJson(ponto);

		ClientResponse response = clientAPIUtil.post(URL+"/add/", JSON);
		
		String retorno = response.getEntity(String.class);
		
		if (retorno.equals("NOK")) throw new Exception("Problem");
		
		
	}
	
	
	
	

	

}
