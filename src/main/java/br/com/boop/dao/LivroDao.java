package br.com.boop.dao;


import java.util.List;

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

	public List<Livro> listarLivrosUsuario(String username) {
		List<Livro> lista = em.createQuery("select l from Livro l where l.proprietario.username = :proprietario", Livro.class)
				.setParameter("proprietario", username).getResultList();
		return lista;
	}
	
	public List<Livro> pesquisar(String termo) {
		List<Livro> lista = em.createQuery("select l from Livro l where l.titulo like :termo", Livro.class)
				.setParameter("termo", "%"+termo+"%").getResultList();
		return lista;
	}
	
	public List<Livro> listarLivros() {
		List<Livro> lista = em.createQuery("select l from Livro l", Livro.class).getResultList();
		return lista;
	}
	
}