package br.com.boop.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Livro;

@RequestScoped
public class LivroDao {
	
	private EntityManager manager;
	
	@Inject
	public LivroDao (EntityManager manager)	{
		this.manager=manager;
	}
	
	public LivroDao () {
		this(null);
	}
	
	public void salvar (Livro livro) {
		manager.getTransaction().begin();
		manager.persist(livro);		
		manager.getTransaction().commit();		
	}
	
	public void remove(Livro livro) {
		manager.getTransaction().begin();
		manager.remove(busca(livro));
		manager.getTransaction().commit();
	}
	

	public Livro busca(Livro livro) {
		return manager.find(Livro.class, livro.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> listaTodos(){
		return manager.createQuery("select p from Livro p").getResultList();
	}
	
}