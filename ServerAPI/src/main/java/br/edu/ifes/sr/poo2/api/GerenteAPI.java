package br.edu.ifes.sr.poo2.api;

import java.security.Provider.Service;

import br.edu.ifes.sr.poo2.api.generic.API;
import br.edu.ifes.sr.poo2.api.model.Gerente;

public interface GerenteAPI extends API<Gerente> {
	
	public boolean login(String email, String senha);
	
	public Service getService (String email, String senha);
	
}
