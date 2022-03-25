package br.com.booksystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tb_livro")
@Data
@RequiredArgsConstructor
public class Livro implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "livro",cascade =  CascadeType.ALL)
	private List<Trecho> trechos;
	private String autor;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private String urlCapa;

	public Livro(String nome, String autor, Genero genero,String urlCapa ){
this.nome=nome;
this.autor=autor;
this.genero=genero;
this.urlCapa=urlCapa;
	}


}
