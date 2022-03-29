package br.com.booksystem.controllers;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("livro")
public class HomeController {
	@Autowired
	private LivroService livroService;
/*	@GetMapping("/home")
	public String home(Model model){

		List<Livro> livros=livroService.findAll();

		model.addAttribute("livros",livros);
		return"home";
	}*/
	@GetMapping("home")
	public ModelAndView home() {
		List<Livro> livros = livroService.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("livros", livros);
		return mv;
	}
	@GetMapping("formulario")
	public String formulario() {

		return "./livro/formulario";
	}
	public ModelAndView generos(){
		List<Genero> generos= livroService.getGeneros();
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("generos", generos);
		return mv;
	}
}
