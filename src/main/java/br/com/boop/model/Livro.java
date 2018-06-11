package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String titulo;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	@Size(min = 10, max = 100, message = "{invalid.size.attribute}")
	private String subtitulo;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private Integer ano;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private Short edicao;
	
	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String isbn;
	
	@OneToOne
	@NotNull(message = "{not.null.attribute}")
	private @Valid Usuario proprietario;
	
	@ManyToOne
	@NotNull(message = "{not.null.attribute}")
	private @Valid Autor autor;
	
	public Livro() {
	}
	
	public Livro(Long id, String titulo, String subtitulo, Integer ano, Short edicao, String isbn, Usuario proprietario,
			Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.ano = ano;
		this.edicao = edicao;
		this.isbn = isbn;
		this.proprietario = proprietario;
		this.autor = autor;
	}


	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public Integer getAno() {
		return ano;
	}
	public Short getEdicao() {
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
