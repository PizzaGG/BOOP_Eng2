package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	@Size(min = 10, max = 100, message = "{invalid.size}")
	private String nome;

	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private Long matricula;
	
	public Usuario() {
	}

	public Usuario(String _nome, long _matricula) {
		this.nome = _nome;
		this.matricula = _matricula;
	}

	public String getNome() {
		return nome;
	}

	public Long getMatricula() {
		return matricula;
	}

}
