package br.com.boop.dao;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Livro;

@RequestScoped
public class LivroDao {
	
	private final EntityManager em;
	
	@Inject
	public LivroDao (EntityManager em)	{
		this.em=em;
	}
	
	protected LivroDao () {
		this(null);
	}
	
	public void salvar (Livro livro) {
		//em.getTransaction().begin();
		if(em==null) {
			System.out.println("lol");
		}
		em.persist(livro);
		//em.getTransaction().commit();
	}
	
	public void remove(Livro livro) {
		//em.getTransaction().begin();
		em.remove(busca(livro));
		//em.getTransaction().commit();
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