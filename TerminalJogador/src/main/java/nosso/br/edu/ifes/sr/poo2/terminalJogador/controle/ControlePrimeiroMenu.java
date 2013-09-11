package nosso.br.edu.ifes.sr.poo2.terminalJogador.controle;

import nosso.br.edu.ifes.sr.poo2.terminalJogador.modelo.AplicacaoPrimeiroMenu;
import nosso.br.edu.ifes.sr.poo2.terminalJogador.visao.ImprimeExcecao;
import nosso.br.edu.ifes.sr.poo2.terminalJogador.visao.SegundoMenu;

public class ControlePrimeiroMenu {
	
	
	public void executar(int opcao) throws Exception
	{
		AplicacaoPrimeiroMenu aplicacaoPrimeiroMenu = new AplicacaoPrimeiroMenu();
		SegundoMenu segundoMenu = new SegundoMenu();
		if (opcao == 1)
		{
			try
			{
				int userID = aplicacaoPrimeiroMenu.cadastrarJogador();
				
			}
			catch(Exception e)
			{
				ImprimeExcecao.imprime(e);
			}				
		}
		else if (opcao == 2)
		{
			try
			{
				String userName = aplicacaoPrimeiroMenu.efetuarLogin();
				segundoMenu.run(userName);
				
			}
			catch(Exception e)
			{
				System.out.println("Usuario Não existe");
				ImprimeExcecao.imprime(e);
			}
		}
		
		
	}
	
	
	
}
