package br.com.boop.dao;


import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Livro;

public class LivroDao {
	
	private final EntityManager em;
	
	@Inject
	public LivroDao (EntityManager em)	{
		this.em=em;
	}
	
	@Deprecated
	protected LivroDao () {
		this(null);
	}
	
	public void salvar (Livro livro) {
		em.persist(livro);		
	}
	
	public void remove(Livro livro) {
		em.remove(busca(livro));
	}
	

	public Livro busca(Livro livro) {
		return em.find(Livro.class, livro.getId());
	}
	
	public Livro busca(Long id) {
		return em.find(Livro.class, id);
	}

	public void atualizar(Livro livro) {
		em.merge(livro);
	}
	
	public void deletar(Long idLivro) {
		em.remove(busca(idLivro));
	}
	
	
}