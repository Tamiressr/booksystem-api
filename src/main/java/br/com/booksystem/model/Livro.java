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


}
