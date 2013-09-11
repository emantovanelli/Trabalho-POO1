
package nosso.br.edu.ifes.sr.terminalgerente.model;

import java.util.Scanner;

import nosso.br.edu.ifes.sr.poo2.api.GerenciaAPI;
import nosso.br.edu.ifes.sr.poo2.api.GerenciaAPIIMpl;
import nosso.br.edu.ifes.sr.poo2.api.model.GerenciaModel;
import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;

import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Gerente;


public class AplicacaoPrimeiroMenu
{
	public int cadastrarGerente() throws Exception
	{
		GerenteAPIIMpl gerenteAPI = new GerenteAPIIMpl();
		Gerente gerente = new Gerente();
		String email, senha;
		Scanner entrada = new Scanner(System.in);
		int IdGerente;
		
		System.out.println("Informe o e-mail do gerente:");
		email = entrada.nextLine().replace("\n", "");
		
		System.out.println("Informe a senha do gerente:");
		senha = entrada.nextLine().replace("\n", "");
		
		gerente.setEmail(email);
		gerente.setSenha(senha);
		
		
		IdGerente = gerenteAPI.adicionar(gerente);
		GerenciaAPI gerenciaAPI = new GerenciaAPIIMpl();
		GerenciaModel gerencia = new GerenciaModel();
		gerencia.setIdGerente(IdGerente);
		gerenciaAPI.adicionar(gerencia);
		
		return IdGerente;
	}
	
	public void logar() throws Exception
	{
		GerenteAPIIMpl gerenteAPI = new GerenteAPIIMpl();
		String email, senha;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o e-mail do gerente:");
		email = entrada.nextLine().replace("\n", "");
		
		System.out.println("Informe a senha do gerente:");
		senha = entrada.nextLine().replace("\n", "");
		
		if (!gerenteAPI.login(email, senha))
		{
			throw new Exception("Erro ao efetuar login. Email ou senha inválido");
		}
	}
}
