package br.com.booksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_trecho")
@Getter
@Setter
@NoArgsConstructor
public class Trecho  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String descricao;
	private String pagina;
	@ManyToOne(cascade =  CascadeType.ALL)
	@JsonIgnore
	private Livro livro;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getPagina() {
	return pagina;
}
public void setPagina(String pagina) {
	this.pagina = pagina;
}
public Livro getLivro() {
	return livro;
}
public void setLivro(Livro livro) {
	this.livro = livro;
}


}
