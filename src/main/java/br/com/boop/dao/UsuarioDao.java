package br.com.boop.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Usuario;

public class UsuarioDao {

	private final EntityManager manager;
	
	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	@Deprecated
	public UsuarioDao() {
		this(null);
	}
	
	public boolean existe(Usuario usuario) {
		return !manager.createQuery("select u from Usuario u where u.nome = "
			+ ":nome and u.matricula = :matricula", Usuario.class)
			.setParameter("nome", usuario.getNome())
			.setParameter("matricula", usuario.getMatricula())
			.getResultList().isEmpty();
	}

	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

}
