package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private final UsuarioDao dao;
	private final Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public LoginController(UsuarioDao dao, Validator validator, Result result, UsuarioLogado _usuarioLogado) {
		this.dao = dao;
		this.usuarioLogado = _usuarioLogado;
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	public LoginController() {
		this(null, null, null, null);
	}

	@Post("/auth")
	public void autentica(UsuarioLogado usuario) {
		if (!dao.existe(usuario)) {
			validator.add(new I18nMessage("login", "login.invalido"));
			validator.onErrorUsePageOf(HomeController.class).index();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(HomeController.class).index();
	}
}