package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.util.List;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Servico;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class ServicoAPIIMpl extends APIGeneric implements ServicoAPI{
	
	public ServicoAPIIMpl()
	{
		URL +="/servico";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}


	public List<Servico> getAll() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/getall");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayListServico = new TypeToken <List<Servico>>(){}.getType();
		
		List<Servico> servicos = gson.fromJson(jsonResposta, arrayListServico);
		
		return servicos;
		
	}

	public int adicionar(Servico t) throws Exception {
		
		String servicoJSON = gson.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add/", servicoJSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}
	

	public Servico get(int i) throws Exception{
		throw new Exception("NotImplemented");
	}
	
	
	
	

	

}
