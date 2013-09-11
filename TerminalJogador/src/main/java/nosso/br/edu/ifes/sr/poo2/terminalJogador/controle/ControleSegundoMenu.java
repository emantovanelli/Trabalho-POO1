package nosso.br.edu.ifes.sr.poo2.terminalJogador.controle;

import nosso.br.edu.ifes.sr.poo2.terminalJogador.modelo.AplicacaoSegundoMenu;
import nosso.br.edu.ifes.sr.poo2.terminalJogador.visao.ImprimeExcecao;

public class ControleSegundoMenu {
	
	public void executar(int opcao, String userName){
		AplicacaoSegundoMenu aplicacaoSegundoMenu = new AplicacaoSegundoMenu();
		
		if (opcao == 1)
		{
			try
			{
				aplicacaoSegundoMenu.verRanking();
				
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
				aplicacaoSegundoMenu.jogar(userName);
				
			}
			catch(Exception e)
			{
				ImprimeExcecao.imprime(e);
			}
		}
		
	}
}
