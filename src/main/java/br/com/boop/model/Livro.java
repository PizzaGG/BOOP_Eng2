package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	private String subtitulo;
	private int ano;
	private short edicao;
	private String isbn;
	
	@OneToOne
	private Usuario proprietario;
	
	@ManyToOne
	private Autor autor;
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public int getAno() {
		return ano;
	}
	public short getEdicao() {
		return edicao;
	}
	public String getIsbn() {
		return isbn;
	}
	public Autor getAutor() {
		return autor;
	}
	public Usuario getProprietario() {
		return proprietario;
	}
}
