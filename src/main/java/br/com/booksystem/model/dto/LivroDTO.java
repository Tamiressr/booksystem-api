package br.com.booksystem.model.dto;

import br.com.booksystem.model.Genero;
import br.com.booksystem.model.Livro;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class LivroDTO implements Serializable {
	@NotBlank
	private String nome;
	@NotBlank
	private String autor;
	@NotBlank
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

