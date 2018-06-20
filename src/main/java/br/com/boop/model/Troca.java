package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.boop.model.enumerables.Status;

@Entity
public class Troca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario originario;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario destinatario;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Livro livroSolicitado;
	
	private Status statusDoPedido;

	
	public Troca(Usuario originario, Usuario destinatario, Livro livroSolicitado, Status statusDoPedido) {
		this.originario = originario;
		this.destinatario = destinatario;
		this.livroSolicitado = livroSolicitado;
		this.statusDoPedido = statusDoPedido;
	}

	public Troca() {
	}
	
	public void setOriginario(Usuario originario) {
		this.originario = originario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	public void setLivroSolicitado(Livro livroSolicitado) {
		this.livroSolicitado = livroSolicitado;
	}

	public void setStatusDoPedido(Status statusDoPedido) {
		this.statusDoPedido = statusDoPedido;
	}

	public Long getId() {
		return id;
	}

	public Usuario getOriginario() {
		return originario;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}

	public Livro getLivroSolicitado() {
		return livroSolicitado;
	}

	public Status getStatusDoPedido() {
		return statusDoPedido;
	}
	
	
}
