package br.edu.ifes.sr.poo2.controller.model;

import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.model.Gerente;

public class ServicoTemp  {

	public String url;
	
	private Gerente gerente;

	private Categoria categoria;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

		
}
