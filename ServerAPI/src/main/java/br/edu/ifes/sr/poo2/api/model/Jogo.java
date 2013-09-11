package br.edu.ifes.sr.poo2.api.model;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private int idJogo;
	
	private String username;
	
	List<Pergunta> perguntas = new ArrayList<Pergunta>();

	public void add(Pergunta pergunta)
	{
		this.perguntas.add(pergunta);
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	
}
