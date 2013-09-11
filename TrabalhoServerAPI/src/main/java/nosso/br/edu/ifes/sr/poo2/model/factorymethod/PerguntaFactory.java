package nosso.br.edu.ifes.sr.poo2.model.factorymethod;


import nosso.br.edu.ifes.sr.poo2.api.model.NivelModel;
import nosso.br.edu.ifes.sr.poo2.api.model.PerguntaModel;

public class PerguntaFactory
{
	public static PerguntaModel getInstance(NivelModel nivel) 
	{
		return new PerguntaModel(nivel);
	}


			
}
