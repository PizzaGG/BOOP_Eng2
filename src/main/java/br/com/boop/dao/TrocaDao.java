package br.com.boop.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Troca;
import br.com.boop.model.Usuario;

@RequestScoped
public class TrocaDao {

private final EntityManager em;
	
	@Inject
	public TrocaDao (EntityManager em)	{
		this.em=em;
	}
	
	protected TrocaDao () {
		this(null);
	}
	
	public void salvar (Troca troca) {
		em.persist(troca);
	}
	
	public void remover (Troca troca) {
		em.remove(troca);
	}
	
	public void atualizar (Troca troca) {
		em.merge(troca);
	}
	
	public Troca busca (Long id) {
		return em.find(Troca.class, id);
	}
	
	public List<Troca> listarTrocasUsuario (Usuario user){
		List<Troca> lista = em.createQuery("select t from Troca t where t.destinatario = :user", Troca.class)
				.setParameter("user", user).getResultList();
		return lista;
	}
	
	public List<Troca> listarTrocasUsuarioOrig (Usuario user){
		List<Troca> lista = em.createQuery("select t from Troca t where t.originario = :user", Troca.class)
				.setParameter("user", user).getResultList();
		return lista;
	}
	
}
