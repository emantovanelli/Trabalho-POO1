package nosso.br.edu.ifes.sr.poo2.terminalJogador.visao;

import java.util.Scanner;

import nosso.br.edu.ifes.sr.poo2.terminalJogador.controle.ControlePrimeiroMenu;

public class PrimeiroMenu {
	public void run() throws Exception{
		int opcao1 = -1;
		ControlePrimeiroMenu controle =new ControlePrimeiroMenu();
		
		while(opcao1 != 0){
			System.out.println("1 - Cadastrar novo jogador");
			System.out.println("2 - Logar");
			System.out.println("0 - Sair");
			Scanner sc = new Scanner(System.in);
			opcao1 = sc.nextInt();
			if(opcao1 < 0 || opcao1 > 2){
				System.out.println("Opcao invalida");
			}
			else{
				controle.executar(opcao1);
			}
		}
		System.out.println("Saindoooooooooooooooooooooooooo");
	}

}
