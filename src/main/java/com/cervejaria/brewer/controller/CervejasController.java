package com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Cerveja;
import com.cervejaria.brewer.model.Origem;
import com.cervejaria.brewer.model.Sabor;
import com.cervejaria.brewer.repository.Estilos;
import com.cervejaria.brewer.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView modelAndView = new ModelAndView("cerveja/CadastroCerveja");
		modelAndView.addObject("sabores", Sabor.values());
		modelAndView.addObject("origens", Origem.values());
		modelAndView.addObject("estilos", estilos.findAll());
		return modelAndView ;
	}
	
	@RequestMapping(value="/cervejas/novo", method=RequestMethod.POST)
	public ModelAndView novo(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		cadastroCervejaService.salvar(cerveja);
		
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:novo");
	}
	
}
