package nosso.br.edu.ifes.sr.poo2.api.model;

import java.util.HashSet;
import java.util.Set;






public class JogoModel extends ModelModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String userName;
	

	private int pontuacao;
	

	private Set<PerguntaModel> listaPerguntas = new HashSet<PerguntaModel>();
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public HashSet<PerguntaModel> getListaPerguntas() {
		return (HashSet<PerguntaModel>) listaPerguntas;
	}

	public void setListaPerguntas(HashSet<PerguntaModel> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	
	
	public void addPergunta(PerguntaModel perg){
		this.listaPerguntas.add(perg);
	}



	
	
	
	
}
