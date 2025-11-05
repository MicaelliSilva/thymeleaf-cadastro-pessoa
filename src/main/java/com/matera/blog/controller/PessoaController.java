package com.matera.blog.controller;

import com.matera.blog.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import com.matera.blog.service.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class PessoaController {
	
	@Autowired
	private PessoaService service;

	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Pessoa pessoa) {
		
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("pessoa", pessoa);

		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id).get());
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(Pessoa pessoa, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(pessoa);
		}
		
		service.save(pessoa);
		
		return findAll();
	}
}
