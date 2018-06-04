package br.com.boop.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped @Named
public class UsuarioLogado implements Serializable{


	private static final long serialVersionUID = 1552280536327897862L;
	private UsuarioLogado usuario;

	public UsuarioLogado getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioLogado usuario2) {
		this.usuario = usuario2;
	}	
}
