package nosso.br.edu.ifes.sr.poo2.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import nosso.br.edu.ifes.sr.poo2.model.ModelBanco;



@Entity
public class RespostaBanco extends ModelBanco {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private boolean opcaoCorreta;
	
	
	@Column
	private String frase;


	public String getOpcao() {
		return frase;
	}


	public void setFrase(String frase) {
		this.frase = frase;
	}


	public boolean isOpcaoCorreta() {
		return opcaoCorreta;
	}


	public void setOpcaoCorreta(boolean opcaoCorreta) {
		this.opcaoCorreta = opcaoCorreta;
	}


	public Object hasNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
