package br.com.booksystem.controllers;

import br.com.booksystem.model.Livro;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
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


	@PostMapping("novo")
	public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro){

		Livro l=service.save(livro);

		return ResponseEntity.created(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(l).toUri()).build();
	}

}
