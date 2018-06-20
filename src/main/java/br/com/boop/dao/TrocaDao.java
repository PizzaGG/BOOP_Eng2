package br.com.boop.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Troca;

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
	
	public List<Troca> listarTrocasUsuario (String username){
		List<Troca> lista = em.createQuery("select t from Troca t where t.originario = :username", Troca.class)
				.setParameter("username", username).getResultList();
		return lista;
	}
	
}
