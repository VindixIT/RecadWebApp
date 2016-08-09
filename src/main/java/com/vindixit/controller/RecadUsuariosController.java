package com.vindixit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vindixit.model.Recad;

@Controller
public class RecadUsuariosController {

	@RequestMapping(value = "/recad", method = RequestMethod.GET)
	public String recad(Model model) {
		Recad recad = new Recad();
		model.addAttribute("recad", recad);
		return "recad";
	}

	
	@RequestMapping(value = "/recad", method = RequestMethod.POST)
	public String recadSubmit(@ModelAttribute Recad recad, Model model) {
		model.addAttribute("recad", recad);
		return "result";
	}

}