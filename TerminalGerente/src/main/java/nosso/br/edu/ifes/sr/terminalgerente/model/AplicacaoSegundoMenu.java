package nosso.br.edu.ifes.sr.terminalgerente.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import br.edu.ifes.sr.poo2.api.GerenteAPIIMpl;
import br.edu.ifes.sr.poo2.api.ServicoAPI;
import br.edu.ifes.sr.poo2.api.ServicoAPIIMpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import nosso.br.edu.ifes.sr.poo2.api.GerenciaAPIIMpl;
import nosso.br.edu.ifes.sr.poo2.api.PerguntaAPIIMpl;

import nosso.br.edu.ifes.sr.poo2.api.model.GerenciaModel;
import nosso.br.edu.ifes.sr.poo2.api.model.NivelModel;
import nosso.br.edu.ifes.sr.poo2.api.model.PerguntaModel;
import nosso.br.edu.ifes.sr.poo2.api.model.RespostaModel;
import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;
import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;
import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;
import nosso.br.edu.ifes.sr.poo2.model.factorymethod.PerguntaFactory;
import br.edu.ifes.sr.poo2.api.model.Servico;

public class AplicacaoSegundoMenu 
{
	public void cadastrarServico() throws Exception
	{
		//Objetos auxiliares
		Servico servico = new Servico();
		Categoria categoria = new Categoria();
		ServicoAPI servicoAPI = new ServicoAPIIMpl();
		String  urlServico; 		
		Gerente gerente;
		int IdServico;
		
		//Cria a categoria do servi�o
		categoria = this.criaCategoria();
		
		//Cria a URL do servi�o
		urlServico = this.criaURLServico();		

		//Busca o gerente do servi�o
		gerente = this.getGerente();
		
		//Insere a categoria no objeto servi�o
		servico.setCategoria(categoria);		
		
		//Insere a url no objeto servi�o
		servico.setUrl(urlServico);		
		
		//Insere o gerente o objeto servi�o
		servico.setGerente(gerente);
		
		//Adiciona o servi�o
		IdServico = servicoAPI.adicionar(servico);
		
		//Atualiza a tabela gerencia no banco de dados inserindo o Id do servi�o cadastrado
		this.atualizaGerencia(IdServico);
	}
	
	private void atualizaGerencia(int IdServico) throws Exception
	{
		ArrayList<GerenciaModel> arrayGerencia = new ArrayList<GerenciaModel>();
		GerenciaAPIIMpl gerenciaAPI = new GerenciaAPIIMpl();
		GerenciaModel gerencia;
		
		arrayGerencia = (ArrayList<GerenciaModel>) gerenciaAPI.getAll();
		gerencia = arrayGerencia.get(0);
		gerencia.setIdServico(IdServico);
		
		gerenciaAPI.adicionar(gerencia);
	}
	
	private Categoria criaCategoria()
	{
		Categoria categoria = new Categoria();
		Scanner entrada = new Scanner(System.in);
		String nomeCategoria, descricaoCategoria;
		
		//L� o nome da categoria
		System.out.println("Digite o nome da categoria: ");
		nomeCategoria = entrada.nextLine().replace("\n", "");
		
		//L� a descri��o da categoria
		System.out.printf("\nDigite uma descricao para a categoria: ");
		descricaoCategoria = entrada.nextLine();
		
		//Armazena o nome e a descri��o
		categoria.setNome(nomeCategoria);
		categoria.setDescricao(descricaoCategoria);
		
		return categoria;
	}
	
	private Gerente getGerente() throws Exception
	{
		GerenciaAPIIMpl gerenciaAPI = new GerenciaAPIIMpl();
		GerenteAPIIMpl gerenteAPI = new GerenteAPIIMpl();
		List<GerenciaModel> gerencia = new ArrayList<GerenciaModel>();
		Gerente gerente;
		try
		{			
			gerencia = gerenciaAPI.getAll();
			
			gerente = gerenteAPI.get(gerencia.get(0).getIdGerente());
			
			return gerente;
		}
		catch(Exception e)
		{
			e = new Exception("Erro de conex�o com o servidor");
			throw e;
		}
	}
	
	private String criaURLServico()
	{
		String urlServico;
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("Informe a url do servi�o:\n");
		urlServico = entrada.nextLine().replace("\n", "");
		
		return urlServico;
	}
	
	public void cadastrarPergunta() throws Exception
	{	
		NivelModel nivelFacil = NivelModel.FACIL;
		NivelModel nivelMedio = NivelModel.MEDIO;
		NivelModel nivelDificil = NivelModel.DIFICIL;
		
		RandomAccessFile file = new RandomAccessFile("C:/Users/Casa/workspace/perguntas_faceis.txt", "r");
	
		this.armazenaPerguntas(file, nivelFacil);
		
		file.close();
		
		file = new RandomAccessFile("C:/Users/Casa/workspace/perguntas_medias.txt", "r");
		
		this.armazenaPerguntas(file, nivelMedio);
		
		file.close();
		
		file = new RandomAccessFile("C:/Users/Casa/workspace/perguntas_dificeis.txt", "r");
		
		this.armazenaPerguntas(file, nivelDificil);
		
		file.close();	
		
		System.out.println("Cadastro de perguntas realizado com sucesso");
	}	
		
	private void armazenaPerguntas(RandomAccessFile file, NivelModel nivel) throws Exception
	{
		PerguntaAPIIMpl api = new PerguntaAPIIMpl();
		String pergunta, resposta;
		PerguntaModel p;
		RespostaModel r;
		HashSet<RespostaModel> respostas = new HashSet<RespostaModel>();
		int i, j;
		
		for (i = 0; i < 10; i++)
		{
			respostas = new HashSet<RespostaModel>();
			
			p = PerguntaFactory.getInstance(nivel);
			pergunta = file.readLine().replace("\n", "");
			
		    p.setPergunta(pergunta);
		    
		    r = new RespostaModel();
		    
		    resposta = file.readLine().replace("\n", "");
		    
		    r.setFrase(resposta);
		    r.setOpcaoCorreta(true);
		    
		   respostas.add(r);
		    
		    for (j = 0; j < 2; j++)
		    {
		    	r = new RespostaModel();
			    
			    resposta = file.readLine().replace("\n", "");
			    
			    r.setFrase(resposta);
			    r.setOpcaoCorreta(false);
			    
			    respostas.add(r);
		    }
		    
		    file.readLine();
		    
		    p.setOpcoes(respostas);
		    
		    
		    api.adicionar(p);
		}
	}
}
