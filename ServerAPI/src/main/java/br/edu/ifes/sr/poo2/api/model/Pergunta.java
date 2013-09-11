package br.edu.ifes.sr.poo2.api.model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
	
	private String valor;

	private int id;
	
	private List<Resposta> respostas = new ArrayList<Resposta>();

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	public void add(Resposta resposta)
	{
		this.respostas.add(resposta);
	}
		
	

}
