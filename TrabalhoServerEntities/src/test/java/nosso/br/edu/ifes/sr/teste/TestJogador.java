package nosso.br.edu.ifes.sr.teste;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import nosso.br.edu.ifes.sr.poo2.model.JogadorBanco;
import nosso.br.edu.ifes.sr.poo2.model.JogoBanco;
import nosso.br.edu.ifes.sr.poo2.service.JogadorService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TestJogador extends AbstractTest {

	@Autowired
	JogadorService serviceJogador = new JogadorService();

	@Test
	public void save(){
		JogadorBanco jogador = new JogadorBanco();
		String userName = "ximbaland";
		Set<JogoBanco> listaJogo = new HashSet<JogoBanco>();
		jogador.setUsername(userName);
		jogador.setListaJogos(listaJogo);
		
		serviceJogador.save(jogador);
		
		Assert.assertNotSame(jogador.getId(), 0);
		
		

	}
	
	@Test
	public void find(){
		
		JogadorBanco jogador = new JogadorBanco();
		String userName = "ximbaland";
		jogador.setUsername(userName);
		
		serviceJogador.save(jogador);
		
		Assert.assertNotSame(jogador.getId(), 0);
		
		JogadorBanco jogadorBanco = serviceJogador.findByUsername(jogador.getUsername());
		
		Assert.assertSame(jogador.getId(), jogadorBanco.getId());
		
	}
	
	
}
