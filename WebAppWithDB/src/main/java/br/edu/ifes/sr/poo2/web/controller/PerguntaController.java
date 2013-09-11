package br.edu.ifes.sr.poo2.web.controller;

import java.util.HashSet;

import nosso.br.edu.ifes.sr.poo2.api.model.NivelModel;
import nosso.br.edu.ifes.sr.poo2.api.model.PerguntaModel;
import nosso.br.edu.ifes.sr.poo2.api.model.RespostaModel;
import nosso.br.edu.ifes.sr.poo2.model.NivelBanco;
import nosso.br.edu.ifes.sr.poo2.model.PerguntaBanco;
import nosso.br.edu.ifes.sr.poo2.model.RespostaBanco;
import nosso.br.edu.ifes.sr.poo2.service.PerguntaService;
import nosso.br.edu.ifes.sr.poo2.service.RespostaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pergunta")
public class PerguntaController extends AbstractController {
	@Autowired
	private PerguntaService service;
	
	@Autowired
	private RespostaService respostaService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<String> add(@RequestBody PerguntaModel pergunta) {
		try {
			NivelBanco nivel;
			HashSet<RespostaBanco> arrayRespostaBanco = new HashSet<RespostaBanco>();
			
			PerguntaBanco p = new PerguntaBanco();
			p.setId(pergunta.getId());		
			if(pergunta.getNivel() == NivelModel.FACIL){
				p.setNivel(NivelBanco.FACIL);
			}
			else if(pergunta.getNivel() == NivelModel.MEDIO){
				p.setNivel(NivelBanco.MEDIO);
			}
			else{
				p.setNivel(NivelBanco.DIFICIL);
			}
			
			for(RespostaModel resp : pergunta.getOpcoes()){
				RespostaBanco r = new RespostaBanco();
				r.setFrase(resp.getOpcao());
				r.setId(resp.getId());
				r.setOpcaoCorreta(resp.isOpcaoCorreta());
				arrayRespostaBanco.add(r);
			}
			
			p.setOpcoes(arrayRespostaBanco);
			
			service.save(p);
			for(RespostaBanco r : p.getOpcoes()){
				respostaService.save(r);
			}
			
			
			
			PerguntaBanco perg = service.find(pergunta.getId());
			
			return new ResponseEntity<String>(perg.getId().toString(),
					HttpStatus.OK);
		}

		 catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PerguntaModel> get(@PathVariable Long id) {
		try {
			
			PerguntaBanco pergunta = service.find(id);
			PerguntaModel perguntaAPI = new PerguntaModel();
			
			perguntaAPI.setId(pergunta.getId());
			perguntaAPI.setPergunta(pergunta.getPergunta());

			for(RespostaBanco resp : pergunta.getOpcoes()){
				RespostaModel r = new RespostaModel();
				r.setFrase(resp.getOpcao());
				r.setId(resp.getId());
				perguntaAPI.addOpcao(r);
			}
			
			if(pergunta.getNivel() == NivelBanco.FACIL){
				perguntaAPI.setNivel(NivelModel.FACIL);
			}
			else if(pergunta.getNivel() == NivelBanco.MEDIO){
				perguntaAPI.setNivel(NivelModel.MEDIO);
			}
			else{
				perguntaAPI.setNivel(NivelModel.DIFICIL);
			}

			return new ResponseEntity<PerguntaModel>(perguntaAPI, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<PerguntaModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
