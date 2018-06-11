package br.com.boop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	@Size(min = 10, max = 100, message = "{invalid.size}")
	private String nome;

	@NotNull(message = "{not.null.attribute}")
	@OneToMany
	private List<Livro> producoes;

	public Long getId() {
		return id;
	}
	
	public List<Livro> getProducoes() {
		return producoes;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProducoes(List<Livro> producoes) {
		this.producoes = producoes;
	}

	public Autor () {
		
	}
	public Autor(long id, String nome, List<Livro> lista) {
		this.id = id;
		this.nome = nome;
		this.producoes = lista;
	}
}
