package br.edu.ifes.sr.poo2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Jogador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String username;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Ponto> pontos = new HashSet<Ponto>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(Set<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	public void adicionarPonto (Ponto ponto){
		pontos.add(ponto);
	}
	
}
