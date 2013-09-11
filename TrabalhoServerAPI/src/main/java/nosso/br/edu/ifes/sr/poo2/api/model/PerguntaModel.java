package nosso.br.edu.ifes.sr.poo2.api.model;

import java.util.HashSet;
import java.util.Set;



public class PerguntaModel extends ModelModel {
	
	private static final long serialVersionUID = 1L;
	

	private String pergunta;
	

	private NivelModel nivel;
		

	private Set<RespostaModel> opcoes = new HashSet<RespostaModel>();
	
	public PerguntaModel(){
		
	}
	public  PerguntaModel(NivelModel nivel){
		this.nivel = nivel;
	}
	
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	
	public NivelModel getNivel() {
		return nivel;
	}

	public void setNivel(NivelModel nivel) {
		this.nivel = nivel;
	}

	public Set<RespostaModel> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(Set<RespostaModel> opcoes) {
		this.opcoes = opcoes;
	}

	public int tamListaRespostas(){
		return this.opcoes.size();
	}
	
	public void addOpcao(RespostaModel opcao){
		this.opcoes.add(opcao);
	}
	
	public RespostaModel iterator(){
		return (RespostaModel) this.opcoes.iterator();
	}
	
	public void removerOpcao(int posicao){
		this.opcoes.remove(posicao);
	}
	
	
	
	

}