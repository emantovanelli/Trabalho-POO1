package nosso.br.edu.ifes.sr.poo2.api.model;



import java.util.HashSet;
import java.util.Set;



public class JogadorModel extends ModelModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String username;
	
	private Set<JogoModel> listaJogos = new HashSet<JogoModel>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
	
	public Set<JogoModel> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(Set<JogoModel> listaJogos) {
		this.listaJogos = listaJogos;
	}

	public void addLista(JogoModel j){
		listaJogos.add(j);
	}
	
	public JogoModel getJogoLista(int i){
		return (JogoModel) listaJogos.iterator();
	}
	
	
}
