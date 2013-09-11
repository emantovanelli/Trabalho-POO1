package nosso.br.edu.ifes.sr.terminalgerente.view;

import java.util.Scanner;

import nosso.br.edu.ifes.sr.terminalgerente.control.ControlePrimeiroMenu;

public class PrimeiroMenu
{
	public static void exibe()
	{
		int opcao = -1;
		Scanner entrada = new Scanner(System.in);
		
		while (opcao != 0)
		{
			System.out.printf("\n1 - Cadastrar gerente \n2 - logar \n0 - sair \n");
			
			opcao = entrada.nextInt();
			
			if(opcao < 0 || opcao > 2)
			{
				System.out.println("Opção inválida");
			}
			else
			{
				ControlePrimeiroMenu.executa(opcao);
			}
			
		}
		
		entrada.close();
	}
}
