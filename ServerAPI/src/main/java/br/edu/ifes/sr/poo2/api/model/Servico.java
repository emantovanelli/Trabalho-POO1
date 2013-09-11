package br.edu.ifes.sr.poo2.api.model;



public class Servico extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String url;
	
	private Categoria categoria;
	
	private Gerente gerente;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	



		
		
	
}
