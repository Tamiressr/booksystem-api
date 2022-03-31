package br.com.booksystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_livro")
@Data
@RequiredArgsConstructor
public class Livro implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	private String nome;
	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	private List<Trecho> trechos=new ArrayList<>();
	private String autor;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Genero> generos = new ArrayList<>();
	private String urlCapa;

	public Livro(String nome, String autor, String urlCapa) {
		this.nome = nome;
		this.autor = autor;
		this.urlCapa = urlCapa;
	}

	public void cadastrarGenero(Genero genero) {
		this.generos.add(genero);

	}

}
