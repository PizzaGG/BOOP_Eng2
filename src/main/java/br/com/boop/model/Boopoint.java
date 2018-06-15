package br.com.boop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Boopoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Usuario titular;

	private Integer quantidade;
	private Integer blocked;

	public Boopoint(Usuario _titular, Integer _quantidade) {
		this.titular = _titular;
		this.quantidade = _quantidade;
	}

	public Boopoint() {
	}

	public Long getId() {
		return id;
	}

	/**
	 * Metodo de retorno do usuario titular dos boopoints;
	 * @return - Usuario proprietario dos boopoints.
	 */
	public Usuario getTitular() {
		return titular;
	}

	/**
	 * Metodo de retorno da quantidade de boopoints do usuario;
	 * @return - Quantidade de boopoints do usuario.
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * Metodo chamado quando um usuario confirmar a entrega de um livro para outro usuario;
	 */
	public void addBoopoint() {
		this.quantidade += 1;
	}

	/**
	 * Metodo chamado quando um usuario solicitar uma troca de um livro;
	 */
	public void blockBoopoint() {
		this.quantidade -= 1;
		this.blocked += 1;
	}

	/**
	 * Metodo chamado quando a troca dos livros for confirmada por ambos os usuarios;
	 */
	public void eraseBoopoint() {
		this.blocked -= 1;
	}

	/**
	 * Metodo chamado quando a troca for cancelada por quaisquer dos envolvidos
	 */
	public void revertBoopoint() {
		this.blocked -= 1;
		this.quantidade += 1;
	}
}
