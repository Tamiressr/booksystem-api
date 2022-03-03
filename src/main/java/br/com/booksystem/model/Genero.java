package br.com.booksystem.model;

import lombok.Getter;

@Getter
public enum Genero {
	ROMANCE("Romance"),
	FANTASIA("Fantasia"),
	FICCAO("Ficção"),
	SCI_FI("Sci-Fi"),
	TERROR("Terror"),
	AUTOAJUDA("Autoajuda");

	private String valor;
	Genero(String valor){
		this.valor=valor;
	}
}
