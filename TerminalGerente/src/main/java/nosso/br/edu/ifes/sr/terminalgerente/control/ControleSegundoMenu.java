package nosso.br.edu.ifes.sr.terminalgerente.control;

import nosso.br.edu.ifes.sr.terminalgerente.model.AplicacaoSegundoMenu;
import nosso.br.edu.ifes.sr.terminalgerente.view.ImprimeExcecao;

public class ControleSegundoMenu 
{
	public static void executa(int opcao)
	{
		AplicacaoSegundoMenu aplicacao = new AplicacaoSegundoMenu();
		
		switch(opcao)
		{			
			case 1:
				try
				{
					aplicacao.cadastrarServico();
				}
				catch(Exception e)
				{
					ImprimeExcecao.imprime(e);
				}
				break;
			
			case 2:
				try
				{
					aplicacao.cadastrarPergunta();
				}
				catch(Exception e)
				{
					ImprimeExcecao.imprime(e);
				}
				break;
		}
	}
}
