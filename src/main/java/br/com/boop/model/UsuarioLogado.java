package br.com.boop.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("usuarioLog")
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 1552280536327897862L;
	private static Usuario usuario;
	private static String nomeUsuario;
	private static Long matriculaUsuario;
	private static String tipoUsuario;
	private static String nome = "tst";

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public Long getMatriculaUsuario() {
		return matriculaUsuario;
	}

	public void setMatriculaUsuario(Long matriculaUsuario) {
		UsuarioLogado.matriculaUsuario = matriculaUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		UsuarioLogado.tipoUsuario = tipoUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		UsuarioLogado.nomeUsuario = nomeUsuario;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario _usuario) {
		usuario = _usuario;
		matriculaUsuario = _usuario.getMatricula();
		nomeUsuario = _usuario.getNome();
		tipoUsuario = _usuario.getTipoUsuario().equals(UserType.TROCANTE)? "TROCANTE": "ADMINISTRADOR";
	}
}
