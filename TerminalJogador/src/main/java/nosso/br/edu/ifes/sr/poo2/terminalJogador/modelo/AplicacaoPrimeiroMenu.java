package nosso.br.edu.ifes.sr.poo2.terminalJogador.modelo;

import java.util.Scanner;

import br.edu.ifes.sr.poo2.api.JogadorAPI;
import br.edu.ifes.sr.poo2.api.JogadorAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Jogador;

public class AplicacaoPrimeiroMenu {
	public int cadastrarJogador() throws Exception{
		Scanner sc = new Scanner(System.in);
		Jogador jogador = new Jogador();
		JogadorAPI jogadorAPI = new JogadorAPIIMpl();
		
		System.out.print("Digite o nome de email: ");
		String email = sc.next();
		
		System.out.println();
		
		System.out.print("Digite o nome de usuario: ");
		String usuario = sc.next();
		
		System.out.println();
		
		System.out.print("Digite a senha: ");
		String senha = sc.next();
		
		jogador.setEmail(email);
		jogador.setSenha(senha);
		jogador.setUsername(usuario);
		
		return jogadorAPI.adicionar(jogador);

	}
	
	public String efetuarLogin() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		JogadorAPI jogadorAPI = new JogadorAPIIMpl();
		
		System.out.print("Digite email: ");
		String email = sc.next();
		
		System.out.print("Digite a senha: ");
		String senha = sc.next();
		
		String userName = jogadorAPI.login(email, senha);
		return userName;
		
	}
}
