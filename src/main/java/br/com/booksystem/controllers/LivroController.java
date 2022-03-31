package br.com.booksystem.controllers;

import br.com.booksystem.model.Livro;
import br.com.booksystem.model.dto.LivroDTO;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="livro")
public class LivroController {

	@Autowired
	private LivroService service;


	@GetMapping(value="all")
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro>livros=service.findAll();
		System.out.println(livros);
		return ResponseEntity.ok().body(livros);
	}


	/*	@GetMapping("/home")
		public String home(Model model){

			List<Livro> livros=livroService.findAll();

			model.addAttribute("livros",livros);
			return"home";
		}*/
	@GetMapping("home")
	public ModelAndView home() {
		List<Livro> livros = service.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("livros", livros);
		return mv;
	}
	@GetMapping("cadastro")
	public String formulario() {

		return "formulario";
	}
	public ModelAndView livrosPorGenero(Long id){
		List<Livro> livros= service.getLivrosGenero(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("livros", livros);
		return mv;
	}
	@PostMapping("novo")
	public ResponseEntity<Livro> save(LivroDTO dto){

		Livro l=service.save(dto.toLivro());
		return ResponseEntity.ok(l);
	}

}
