package nosso.br.edu.ifes.sr.poo2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;



import nosso.br.edu.ifes.sr.poo2.model.ModelBanco;


@Entity
public class JogoBanco extends ModelBanco {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String userName;
	
	@Column
	private int pontuacao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<PerguntaBanco> listaPerguntas = new HashSet<PerguntaBanco>();
	
	

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

	public HashSet<PerguntaBanco> getListaPerguntas() {
		return (HashSet<PerguntaBanco>) listaPerguntas;
	}

	public void setListaPerguntas(HashSet<PerguntaBanco> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	
	
	public void addPergunta(PerguntaBanco perg){
		this.listaPerguntas.add(perg);
	}



	
	
	
	
}
