package br.com.booksystem.controllers;

import br.com.booksystem.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("genero")
public class GeneroController {
	@Autowired
	private GeneroService service;
}
