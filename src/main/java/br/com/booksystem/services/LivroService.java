package br.com.booksystem.services;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import br.com.booksystem.model.Trecho;
import br.com.booksystem.repositories.LivroRepository;
import br.com.booksystem.repositories.TrechoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;
	@Autowired
	private TrechoRepository trechoRepository;
	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro save(Livro livro) {
		for(Trecho t:livro.getTrechos()){
			t.setLivro(livro);
			trechoRepository.save(t);
		}

		return repository.save(livro);
	}

	public List<Genero> getGeneros() {
		return new ArrayList<>();
	}
}
