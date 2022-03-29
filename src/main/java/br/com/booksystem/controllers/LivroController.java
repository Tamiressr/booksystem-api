package br.com.booksystem.controllers;

import br.com.booksystem.model.Livro;
import br.com.booksystem.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/livros")
public class LivroController {

	@Autowired
	private LivroService service;


	@GetMapping(value="/all")
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro>livros=service.findAll();
		return ResponseEntity.ok().body(livros);
	}

@PostMapping

	public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro){

	 Livro l=service.save(livro);

	 return ResponseEntity.ok(l);
}

}
