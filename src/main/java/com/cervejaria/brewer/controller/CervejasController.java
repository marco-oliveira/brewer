package com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cervejaria.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value="/cervejas/novo", method=RequestMethod.POST)
	public String novo(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return "redirect:novo";
	}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
	
}
