package br.com.booksystem.services;

import br.com.booksystem.model.Trecho;
import br.com.booksystem.repositories.TrechoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrechoService {
	@Autowired
	private TrechoRepository repository;
	public Trecho save(Trecho trecho){
		Trecho t= repository.save(trecho);
		return t;
	}
public List<Trecho> findAll(){
	List<Trecho> t= repository.findAll();
	return t;
}
}
