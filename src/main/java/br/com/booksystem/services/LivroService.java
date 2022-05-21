package br.com.booksystem.services;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import br.com.booksystem.model.Trecho;
import br.com.booksystem.model.dto.LivroDTO;
import br.com.booksystem.repositories.GeneroRepository;
import br.com.booksystem.repositories.LivroRepository;
import br.com.booksystem.repositories.TrechoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private TrechoService trechoService;
    @Autowired
    private GeneroService generoService;

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro save(Livro livro) {
        for (Trecho t : livro.getTrechos()) {
            t.setLivro(livro);
            log.info("Salvando Trecho");
			trechoService.save(t);

        }
        for (Genero genero : livro.getGeneros()) {

            //comparar se já existe genero e não salvar se existir
            if (generoService.jaExiste(genero.getNome())) {
                Genero g=generoService.findByNome(genero.getNome());
                generoService.save(g);
				log.warn("repetindo genero");
            } else {
                log.info("Salvando Genero");
                generoService.save(genero);
            }

        }
         log.info("Salvando Livro");
        return repository.save(livro);
    }

    public List<Livro> getLivrosGenero(Long id) {
        return repository.findByGeneros(id);
    }

    public Livro convertDto(LivroDTO dto) {
        return new Livro(dto.getNome(), dto.getAutor(), dto.getUrlCapa());
    }
}
