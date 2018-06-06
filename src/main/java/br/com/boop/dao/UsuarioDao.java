package br.com.boop.dao;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.boop.model.Usuario;

@RequestScoped
public class UsuarioDao  {

	protected final EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	protected UsuarioDao() {
		this(null);
	}

	public boolean existe(Usuario usuario) {
		return !manager
				.createQuery("select u from Usuario u where u.nome = " + ":nome and u.matricula = :matricula",
						Usuario.class)
				.setParameter("nome", usuario.getNome()).setParameter("matricula", usuario.getMatricula())
				.getResultList().isEmpty();
	}

	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		// TODO fazer o corpo
	}

}
