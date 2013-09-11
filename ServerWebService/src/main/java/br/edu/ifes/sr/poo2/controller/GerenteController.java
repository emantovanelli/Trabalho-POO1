package br.edu.ifes.sr.poo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.model.Gerente;
import br.edu.ifes.sr.poo2.service.GerenteService;


@Controller
@RequestMapping("/gerente")
public class GerenteController extends AbstractController {

	@Autowired
	private GerenteService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody Gerente gerente) {
		try {

				Gerente gerenteX = service.findByEmail(gerente.getEmail());
				//Gerente não existe		
				if (gerenteX==null){
					
					service.save(gerente);
					
					return new ResponseEntity<String>(gerente.getId().toString(),
							HttpStatus.OK);
				}
				//Gerente Existe
				else{
					
					return new ResponseEntity<String>("-1",
							HttpStatus.OK);
					
				}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Gerente gerente) {
		try {
				String resposta = "NOK";
				Gerente gerenteX = service.findByEmail(gerente.getEmail());
				
				if ((gerenteX!=null) && (gerente.getSenha().equals(gerenteX.getSenha())))
				{
					resposta = "OK";
				}
				
				return new ResponseEntity<String>(resposta,
						HttpStatus.OK);
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("NOK",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// Retornando um usuario;
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Gerente> get(@PathVariable Long id) {
		try {

			Gerente gerente = service.find(id);

			return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Gerente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Retornando um lista de gerentes
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Gerente>> get() {
		try {

			List<Gerente> gerentes = service.findAll();

			return new ResponseEntity<List<Gerente>>(gerentes, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Gerente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
}
