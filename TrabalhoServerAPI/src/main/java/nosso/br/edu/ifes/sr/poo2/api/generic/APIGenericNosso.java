package nosso.br.edu.ifes.sr.poo2.api.generic;

import nosso.br.edu.ifes.sr.poo2.api.util.ClientAPIUtil;

import com.google.gson.Gson;

public abstract class APIGenericNosso {
	
	protected String URLNosso = "http://trabalho.jelastic.websolute.net.br/webappwithdb/rest/";
	// http://ec2-54-200-31-113.us-west-2.compute.amazonaws.com:8080
	
	protected Gson gsonNosso = new Gson();
	
	protected ClientAPIUtil clientAPIUtil = new ClientAPIUtil();

}
