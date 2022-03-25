package br.com.booksystem.controllers;

import br.com.booksystem.model.Livro;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private LivroService livroService;
	@GetMapping("/home")
	public String home(Model model){

		List<Livro> livros=livroService.findAll();

		model.addAttribute("livros",livros);
		return"home";
	}
}
