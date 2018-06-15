package br.com.boop.dao;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<Livro> listarLivros() {
		TypedQuery<Livro> array = em.createQuery("SELECT * FROM livro",Livro.class);
		List<Livro> lista = array.getResultList();
		return lista;
	}
	
}