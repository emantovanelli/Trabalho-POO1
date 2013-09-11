package nosso.br.edu.ifes.sr.poo2.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



import nosso.br.edu.ifes.sr.poo2.model.ModelBanco;

@Entity
public class JogadorBanco extends ModelBanco{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String username;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<JogoBanco> listaJogos = new HashSet<JogoBanco>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
	
	public Set<JogoBanco> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(Set<JogoBanco> listaJogos) {
		this.listaJogos = listaJogos;
	}

	public void addLista(JogoBanco j){
		listaJogos.add(j);
	}
	
	public JogoBanco getJogoLista(int i){
		return (JogoBanco) listaJogos.iterator();
	}
	
	
}
