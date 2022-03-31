package br.com.booksystem.services;

import br.com.booksystem.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
	@Autowired
	private GeneroRepository repository;

}
