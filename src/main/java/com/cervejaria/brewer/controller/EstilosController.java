package com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.service.CadastroEstiloService;

@Controller
public class EstilosController {
	
	@Autowired
	private CadastroEstiloService cadastroEstiloService;

	@RequestMapping("estilos/novo")
	public ModelAndView novo(Estilo estilo){
		ModelAndView modelAndView = new ModelAndView("estilo/CadastroEstilo");
		modelAndView.addObject("estilo", estilo);
		
		return modelAndView;
	}
	
	@RequestMapping(value="estilos/novo", method=RequestMethod.POST)
	public ModelAndView novo(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(estilo);
		}
		
		cadastroEstiloService.salvar(estilo);
		
		attributes.addFlashAttribute("mensagem", "Estilo salvo com Sucesso!");
		return new ModelAndView("redirect:novo");
	}
}
