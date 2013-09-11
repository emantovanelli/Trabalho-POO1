package nosso.br.edu.ifes.sr.terminalgerente.control;

import nosso.br.edu.ifes.sr.terminalgerente.model.AplicacaoPrimeiroMenu;
import nosso.br.edu.ifes.sr.terminalgerente.view.ImprimeExcecao;
import nosso.br.edu.ifes.sr.terminalgerente.view.SegundoMenu;

public class ControlePrimeiroMenu 
{
	public static void executa(int opcao) 
	{
		AplicacaoPrimeiroMenu aplicacao = new AplicacaoPrimeiroMenu();
		
		switch (opcao)
		{
			case 1:
				try
				{				
					aplicacao.cadastrarGerente();
				}
				catch(Exception e)
				{
					ImprimeExcecao.imprime(e);
				}
				break;
				
			case 2:
				try
				{
					aplicacao.logar();
					SegundoMenu.exibe();
				}
				catch(Exception e)
				{
					ImprimeExcecao.imprime(e);
				}
				break;
		}
	}
}
