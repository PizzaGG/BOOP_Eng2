package br.com.boop.dao;


import java.util.List;

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

	public boolean existe(Long matricula) {
		  return !manager
				.createQuery("select u from Usuario u where u.matricula = :matricula",
						Usuario.class).setParameter("matricula", matricula)
				.getResultList().isEmpty();
	}

	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		manager.merge(usuario);
	}

	public boolean hasUser(String user) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario login(Long matricula, String hashSha256Pass) {
		List<Usuario> res = manager
				.createQuery("select u from Usuario u where u.matricula = :matricula and u.hashSenha = :hash",
				Usuario.class).setParameter("matricula", matricula).setParameter("hash", hashSha256Pass)
				.getResultList();
		if(!res.isEmpty()) {
			return res.get(0);
		} else {
			return null;
		}
	}

}
