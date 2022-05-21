package br.com.booksystem.services;

import br.com.booksystem.model.Genero;
import br.com.booksystem.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;

    public boolean jaExiste(String nome) {
        String nomeGenero = repository.findByNome(nome).get().getNome();
        return nomeGenero.isEmpty() ? true : false;
    }

    public Genero findByNome(String nome) {
        Optional<Genero> genero = repository.findByNome(nome);

        return genero.get();
    }
    public void save(Genero genero){
        repository.save(genero);
    }
}
