package br.com.booksystem.model.dto;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import lombok.Data;

import java.util.List;

@Data
public class LivroDTO {
	private String nome;
	private String autor;
	private String urlCapa;
	private List<Genero> generos;

	public Livro toLivro() {
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livro.setUrlCapa(urlCapa);
		return livro;
	}
}

