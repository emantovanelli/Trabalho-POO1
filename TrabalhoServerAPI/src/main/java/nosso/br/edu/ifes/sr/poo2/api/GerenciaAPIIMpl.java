package nosso.br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

import nosso.br.edu.ifes.sr.poo2.api.generic.APIGenericNosso;
import nosso.br.edu.ifes.sr.poo2.api.model.GerenciaModel;
import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;


public class GerenciaAPIIMpl extends APIGenericNosso implements GerenciaAPI {

	
	public GerenciaAPIIMpl() {
		URLNosso += "/gerencia";
	}

	public boolean isWorking() {
		ClientResponse response = clientAPIUtil.get(URLNosso+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}

	public int adicionar(GerenciaModel t) throws Exception {
		String JSON = gsonNosso.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URLNosso +"/add", JSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}

	public GerenciaModel get(int i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GerenciaModel> getAll() throws Exception 
	{
		ClientResponse response = clientAPIUtil.get(URLNosso+"/getall");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayListGerencia = new TypeToken <List<GerenciaModel>>(){}.getType();
		
		List<GerenciaModel> gerencias = gsonNosso.fromJson(jsonResposta, arrayListGerencia);
		
		return gerencias;
	}



}
