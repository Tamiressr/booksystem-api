package br.com.booksystem.controllers;

import br.com.booksystem.model.Trecho;
import br.com.booksystem.services.TrechoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value="/trechos")
public class TrechoController {


		@Autowired
		private TrechoService service;

		@GetMapping(value="/all")
		public ResponseEntity<List<Trecho>> findAll(){
			List<Trecho>trechos=service.findAll();
			return ResponseEntity.ok().body(trechos);
		}
		@PostMapping
		public ResponseEntity<Trecho> save(@Valid @RequestBody Trecho trecho){
			Trecho t=service.save(trecho);
			return ResponseEntity.ok(t);
		}

}
