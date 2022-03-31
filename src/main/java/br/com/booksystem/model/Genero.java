package br.com.booksystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_genero")
@Data
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public String toString(){
		return this.nome;
	}
}
