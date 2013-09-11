package nosso.br.edu.ifes.sr.poo2.api;

import java.lang.reflect.Type;
import java.util.List;

import nosso.br.edu.ifes.sr.poo2.api.generic.APIGenericNosso;
import nosso.br.edu.ifes.sr.poo2.api.model.PerguntaModel;



import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;



public class PerguntaAPIIMpl extends APIGenericNosso implements PerguntaAPI {
	
	public PerguntaAPIIMpl() {
		URLNosso += "pergunta";
	}

	public boolean isWorking() {
		ClientResponse response = clientAPIUtil.get(URLNosso+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}

	public int adicionar(PerguntaModel t) throws Exception {
		String JSON = gsonNosso.toJson(t);
		
		ClientResponse response = clientAPIUtil.post(URLNosso +"/add", JSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}

	public PerguntaModel get(int id) throws Exception {
		ClientResponse response = clientAPIUtil.get(URLNosso+"/get/"+id);
		
		String jsonResposta = response.getEntity(String.class);
		
		PerguntaModel pergunta = gsonNosso.fromJson(jsonResposta, PerguntaModel.class);
		
		return pergunta;
	}

	public List<PerguntaModel> getAll() throws Exception {
		ClientResponse response = clientAPIUtil.get(URLNosso+"/getall");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type arrayListPergunta = new TypeToken <List<PerguntaModel>>(){}.getType();
		
		List<PerguntaModel> perguntas = gsonNosso.fromJson(jsonResposta, arrayListPergunta);
		
		return perguntas;
	}

}
