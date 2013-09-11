package nosso.br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.JogoAPIImpl;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;

public class APITest {

	/**
	 * @param args
	 */
	
	
	public static void testeJogar(){
		
		String url ="http://localhost:8080/webappwithdb/rest/";
		String username="ximbas";
		Nivel nivel = Nivel.FACIL;
		
		Jogo jogo = new Jogo();
		
		JogoAPIImpl jogoAPI = new JogoAPIImpl(); 
		 jogo = jogoAPI.jogar(username, url, nivel);
		 
		 System.out.println(jogo.getUsername());
		 System.out.println(jogo.getPerguntas().get(0).getValor());
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testeJogar();

	}

}
