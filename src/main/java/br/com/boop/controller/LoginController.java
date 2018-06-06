package br.com.boop.controller;


import javax.inject.Inject;

import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private final UsuarioDao dao;
	private final Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;
	private final UsuarioDao usuarioDao;

	@Inject
	public LoginController(UsuarioDao dao, Validator validator, Result result,UsuarioLogado usuarioLogado, UsuarioDao usuarioDao) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
	}

	@Deprecated
	public LoginController() {
		this(null, null, null, null, null);
	}

	@Post("/auth")
	public void autentica(String user, String pass) {
		if (usuarioLogado != null) {
			MessagesController.addMessage(new BoopMessage("has.logged.user.tittle", "has.loggued.user.message", Severity.WARN));
			result.redirectTo(LoginController.class).home();
			return;
		}
	}
	
	@Get("/")
	public void home() {
	}
}