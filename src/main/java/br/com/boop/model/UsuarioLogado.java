package br.com.boop.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("usuarioLog")
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 1552280536327897862L;
	private static Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public static Usuario getUsuarioStatic() {
		return usuario;
	}
	
	public static String getUsername() {
		return usuario.getUsername();
	}

	public void setUsuario(Usuario _usuario) {
		usuario = _usuario;
	}
}
