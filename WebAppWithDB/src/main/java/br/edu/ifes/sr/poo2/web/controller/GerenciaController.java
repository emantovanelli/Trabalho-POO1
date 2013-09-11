package br.edu.ifes.sr.poo2.web.controller;

import java.util.ArrayList;

import nosso.br.edu.ifes.sr.poo2.api.model.GerenciaModel;
import nosso.br.edu.ifes.sr.poo2.model.GerenciaBanco;
import nosso.br.edu.ifes.sr.poo2.service.GerenciaService;

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
@RequestMapping("/gerencia")
public class GerenciaController extends AbstractController {
	
	
	@Autowired
	private GerenciaService gerenciaService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<String> addGerencia (@RequestBody GerenciaModel gerencia){
		try{
			
			GerenciaBanco g = new GerenciaBanco();
			g.setId(gerencia.getId());
			g.setIdGerente(gerencia.getIdGerente());
			g.setIdServico(gerencia.getIdServico());
			gerenciaService.save(g);


			return new ResponseEntity<String>(g.getId().toString(),
					HttpStatus.OK);
		}
		
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody 
	public ResponseEntity<GerenciaModel> getGerencia (@PathVariable Long id){
		try{
			GerenciaBanco gerencia = gerenciaService.find(id);
			
			GerenciaModel g = new GerenciaModel();
			g.setId(gerencia.getId());
			g.setIdGerente(gerencia.getIdGerente());
			g.setIdServico(gerencia.getIdServico());
			
			return new ResponseEntity<GerenciaModel>(g, HttpStatus.OK);
			
		}
		
		catch(Exception e){
			return new ResponseEntity<GerenciaModel>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody 
	public ResponseEntity<ArrayList<GerenciaModel>> getAll (){
		try{
			ArrayList<GerenciaBanco> arrayGerencia = (ArrayList<GerenciaBanco>) gerenciaService.findAll();
			GerenciaBanco gerencia = arrayGerencia.get(0);
			
			ArrayList<GerenciaModel> model = new ArrayList<GerenciaModel>();
			GerenciaModel g = new GerenciaModel();
			g.setId(gerencia.getId());
			g.setIdGerente(gerencia.getIdGerente());
			g.setIdServico(gerencia.getIdServico());
			
			model.add(g);
			
			return new ResponseEntity<ArrayList<GerenciaModel>>(model, HttpStatus.OK);
			
		}
		
		catch(Exception e){
			return new ResponseEntity<ArrayList<GerenciaModel>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
