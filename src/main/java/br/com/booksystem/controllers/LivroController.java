package br.com.booksystem.controllers;

import br.com.booksystem.model.Livro;
import br.com.booksystem.model.dto.LivroDTO;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("livro")
public class LivroController {

	@Autowired
	private LivroService service;


	@GetMapping(value="all")
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro>livros=service.findAll();
		System.out.println(livros);
		return ResponseEntity.ok().body(livros);
	}

	@GetMapping("home")
	public ModelAndView home() {
		List<Livro> livros = service.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("livros", livros);
		return mv;
	}

	@GetMapping("xpto")
	public String xpto() {
		return "book/xpto";
	}
	@GetMapping("formulario")
	public String formulario() {

		return "livro/formulario";
	}
	public ModelAndView livrosPorGenero(Long id){
		List<Livro> livros= service.getLivrosGenero(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("livros", livros);
		return mv;
	}
	@PostMapping("novo")
	public String save(@Valid LivroDTO dto, BindingResult result){
		if(result.hasErrors()){
			return "livro/formulario";
		}
		Livro l=service.save(dto.toLivro());
		 return "livro/formulario";
	}

}
