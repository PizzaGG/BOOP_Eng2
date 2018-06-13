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
	private Long matricula;
	
	@NotNull(message = "{not.null.attribute}")
	private UserType tipoUsuario;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String hashSenha;
	
	public Usuario() {
	}

	public Usuario(String _nome, long _matricula, String _hashSenha) {
		this.nome = _nome;
		this.matricula = _matricula;
		this.hashSenha = _hashSenha;
	}	

	public void setTipoUsuario(UserType tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public Long getMatricula() {
		return matricula;
	}
	
	public String getHashSenha() {
		return hashSenha;
	}
	
	public void setHashSenha(String _hashSenha) {
		this.hashSenha = _hashSenha;
	}

}
