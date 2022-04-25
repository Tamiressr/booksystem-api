package br.com.booksystem.services;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import br.com.booksystem.model.Trecho;
import br.com.booksystem.model.dto.LivroDTO;
import br.com.booksystem.repositories.GeneroRepository;
import br.com.booksystem.repositories.LivroRepository;
import br.com.booksystem.repositories.TrechoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;
	@Autowired
	private TrechoRepository trechoRepository;
	@Autowired
	private GeneroRepository generoRepository;
	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro save(Livro livro) {
		for(Trecho t:livro.getTrechos()){
			t.setLivro(livro);
			trechoRepository.save(t);
		}
		for(Genero genero:livro.getGeneros()){
			System.out.println(genero);
			//comparar se já existe genero e não salvar se existir
if (generoRepository.findByNome(genero.getNome()).isPresent()){
	System.out.println("repetindo genero ");
}else{
	generoRepository.save(genero);
}

		}

		return repository.save(livro);
	}

	public List<Livro> getLivrosGenero(Long id) {
		return repository.findByGeneros(id);
	}

	public Livro convertDto(LivroDTO dto){
		return new Livro(dto.getNome(),dto.getAutor(),dto.getUrlCapa());
	}
}
