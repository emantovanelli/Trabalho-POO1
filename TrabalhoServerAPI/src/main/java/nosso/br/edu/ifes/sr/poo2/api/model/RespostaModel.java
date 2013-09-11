package nosso.br.edu.ifes.sr.poo2.api.model;








public class RespostaModel extends ModelModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private boolean opcaoCorreta;
	
	

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
