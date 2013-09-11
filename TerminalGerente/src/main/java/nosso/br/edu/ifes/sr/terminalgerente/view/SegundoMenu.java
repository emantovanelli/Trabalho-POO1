package nosso.br.edu.ifes.sr.terminalgerente.view;

import java.util.Scanner;

import nosso.br.edu.ifes.sr.terminalgerente.control.ControleSegundoMenu;

public class SegundoMenu 
{
	public static void exibe()
	{
		
		Scanner entrada = new Scanner(System.in);
		
		for (int opcao = -1; opcao != 0;)
		{
			System.out.printf("1 - Cadastrar serviço \n2 - Cadastrar perguntas e respostas \n0 - sair\n");
			opcao = entrada.nextInt();
			
			if (opcao < 0 || opcao > 2)
			{
				System.out.println("Opção inválida");
			}
			else
			{
				ControleSegundoMenu.executa(opcao);
			}
		}
	}
}
