package br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.security.Provider.Service;
import java.util.List;

import br.edu.ifes.sr.poo2.api.generic.APIGeneric;
import br.edu.ifes.sr.poo2.api.model.Gerente;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class GerenteAPIIMpl extends APIGeneric implements GerenteAPI{
	
	public GerenteAPIIMpl()
	{
		URL +="/gerente";
	}
	
	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}


	public List<Gerente> getAll() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/getall");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayListGerente = new TypeToken <List<Gerente>>(){}.getType();
		
		List<Gerente> gerentes = gson.fromJson(jsonResposta, arrayListGerente);
		
		return gerentes;
		
	}

	public int adicionar(Gerente t) throws Exception {
		
		String usuarioJson = gson.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add",usuarioJson);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}

	public Gerente get(int i) {
		
		ClientResponse response = clientAPIUtil.get(URL+"/get/"+i);
		
		String jsonResposta = response.getEntity(String.class);
		
		Gerente gerente = gson.fromJson(jsonResposta, Gerente.class);
		
		return gerente;
	}

	public boolean login(String email, String senha) {
		
		Gerente gerente = new Gerente();
		
		gerente.setEmail(email);
		gerente.setSenha(senha);
		
		String gerenteJson = gson.toJson(gerente);
		
		ClientResponse response = clientAPIUtil.post(URL+"/login/",gerenteJson);
		
		String jsonResposta = response.getEntity(String.class);
		
		if (jsonResposta.equals("OK")) return true;
		else return false;
		
	}

	public Service getService(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
