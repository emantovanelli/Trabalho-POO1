package nosso.br.edu.ifes.sr.poo2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class PerguntaBanco extends ModelBanco {
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String pergunta;
	
	@Column
	private NivelBanco nivel;
		
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<RespostaBanco> opcoes = new HashSet<RespostaBanco>();
	
	public PerguntaBanco(){
		
	}
	public  PerguntaBanco(NivelBanco nivel){
		this.nivel = nivel;
	}
	
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	
	public NivelBanco getNivel() {
		return nivel;
	}

	public void setNivel(NivelBanco nivel) {
		this.nivel = nivel;
	}

	public Set<RespostaBanco> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(Set<RespostaBanco> opcoes) {
		this.opcoes = opcoes;
	}

	public int tamListaRespostas(){
		return this.opcoes.size();
	}
	
	public void addOpcao(RespostaBanco opcao){
		this.opcoes.add(opcao);
	}
	
	public RespostaBanco iterator(){
		return (RespostaBanco) this.opcoes.iterator();
	}
	
	public void removerOpcao(int posicao){
		this.opcoes.remove(posicao);
	}
	
	
	
	

}