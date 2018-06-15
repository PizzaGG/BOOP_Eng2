package br.com.boop.model;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Size(min = 1, max = 100, message = "{invalid.size}")
	private String nome;

	@NotNull(message = "{not.null.attribute}")
	private Long matricula;
	
	@NotNull(message = "{not.null.attribute}")
	private UserType tipoUsuario;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String email;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String hashSenha;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String username;
	
	@OneToOne
	private Boopoint booPoint;
	private ArrayList<Livro> livros;
	
	public Usuario() {
	}

	public Usuario(String _nome, long _matricula, String _hashSenha, String _email, String _username) {
		this.nome = _nome;
		this.matricula = _matricula;
		this.hashSenha = _hashSenha;
		this.email = _email;
		this.username = _username;
		this.booPoint = new Boopoint(this,0);
		livros = new ArrayList<Livro>();
	}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getTipoUsuario() {
		return tipoUsuario;
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

	public Boopoint getBooPoint() {
		return booPoint;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}
	
}