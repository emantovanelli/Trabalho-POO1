package nosso.br.edu.ifes.sr.poo2.terminalJogador.visao;

import java.util.Scanner;

import nosso.br.edu.ifes.sr.poo2.terminalJogador.controle.ControlePrimeiroMenu;
import nosso.br.edu.ifes.sr.poo2.terminalJogador.controle.ControleSegundoMenu;

public class SegundoMenu {
	public void run(String userName) throws Exception{
		int opcao1 = -1;
		ControleSegundoMenu controle =new ControleSegundoMenu();
		
		while(opcao1 != 0){
			System.out.println("1 - Ver Ranking");
			System.out.println("2 - Jogar");
			System.out.println("0 - Sair");
			Scanner sc = new Scanner(System.in);
			System.out.println("Selecione a opcao");
			
			opcao1 = sc.nextInt();
			if(opcao1 < 0 || opcao1 > 3){
				System.out.println("Opcao invalida");
				
			}
			else{
				controle.executar(opcao1, userName);
			}
		}
	}
}
