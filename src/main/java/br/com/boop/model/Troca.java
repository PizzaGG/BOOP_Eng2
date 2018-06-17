package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.boop.model.enumerables.Status;

@Entity
public class Troca {

	@Id
	private Long id;
	
	@OneToOne
	private Usuario originario;
	
	@OneToOne
	private Usuario destinatario;
	
	@OneToOne
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
