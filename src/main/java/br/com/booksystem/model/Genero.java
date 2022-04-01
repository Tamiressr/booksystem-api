package br.com.booksystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_genero")
@Data
@RequiredArgsConstructor
public class Genero implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public String toString(){
		return this.nome;
	}

}
