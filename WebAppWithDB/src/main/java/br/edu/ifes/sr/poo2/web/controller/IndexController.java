package br.edu.ifes.sr.poo2.web.controller;

import nosso.br.edu.ifes.sr.poo2.service.PerguntaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	PerguntaService perguntaService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String teste()
	{
		Integer tamanho = perguntaService.findAll().size(); 
		
		return tamanho.toString();
	}
	
}
