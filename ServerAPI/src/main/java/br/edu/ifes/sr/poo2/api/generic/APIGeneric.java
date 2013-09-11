package br.edu.ifes.sr.poo2.api.generic;

import br.edu.ifes.sr.poo2.api.util.ClientAPIUtil;

import com.google.gson.Gson;

public abstract class APIGeneric {
	
	protected String URL = "http://leds.sr.ifes.edu.br:8080/QuizWebService/rest/";
	
	protected Gson gson = new Gson();
	
	protected ClientAPIUtil clientAPIUtil = new ClientAPIUtil();

}
