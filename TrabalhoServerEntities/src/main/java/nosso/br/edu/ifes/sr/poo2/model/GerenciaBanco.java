package nosso.br.edu.ifes.sr.poo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class GerenciaBanco extends ModelBanco{

	
	private static final long serialVersionUID = 1L;


	@Column
	private int idGerente;
	
	
	@Column
	private int idServico;


	public int getIdGerente() {
		return idGerente;
	}


	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}


	public int getIdServico() {
		return idServico;
	}


	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	
	
	
	

}
