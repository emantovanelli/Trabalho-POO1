package br.edu.ifes.sr.poo2.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Gerente extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Servico servico;

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
	
}
