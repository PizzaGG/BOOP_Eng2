package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String titulo;

	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String subtitulo;

	@NotNull(message = "{not.null.attribute}")
	private Integer ano;

	@NotNull(message = "{not.null.attribute}")
	private Short edicao;

	@NotNull(message = "{not.null.attribute}")
	@NotEmpty(message = "{not.empty.attribute}")
	@NotBlank(message = "{not.blank.attribute}")
	private String isbn;

	@ManyToOne
	@NotNull(message = "{not.null.attribute}")
	private Usuario proprietario;

	@NotNull(message = "{not.null.attribute}")
	private String autor;

//	@Lob
//	private byte[] imagem;
//
//	private UploadedFile setImagem;

	public Livro() {

	}

	public Livro(Long id, String titulo, String subtitulo, Integer ano, Short edicao, String isbn, Usuario proprietario,
			String autor) {
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setEdicao(Short edicao) {
		this.edicao = edicao;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public String getAutor() {
		return autor;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

//	public UploadedFile getSetImagem() {
//		return setImagem;
//	}
//
//	public void setSetImagem(UploadedFile imagem) {
//		this.setImagem = imagem;
//	}

}
