package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.UsuarioLogado;
import br.com.boop.util.HashPasswordGenerator;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;

@Controller
public class LoginController {

	private final Result result;
	private final UsuarioDao usuarioDao;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public LoginController(Result result,
			UsuarioDao usuarioDao, UsuarioLogado usuarioLogado) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
	}

	@Deprecated
	public LoginController() {
		this(null, null, null);
	}

	@Post("/auth")
	public void autentica(String usuario, String senha) {
		if (usuarioLogado.getUsuario() != null) {
			MessagesController
					.addMessage(new BoopMessage("has.logged.user.title", "has.logged.user.message", Severity.WARN));
			result.redirectTo(HomeController.class).home();
			return;
		}
		if (usuarioDao.existe(usuario)) {
			 usuarioLogado.setUsuario(usuarioDao.login(usuario, HashPasswordGenerator.getHashSha256(senha)));
			 if (usuarioLogado.getUsuario()==null) {
				 MessagesController.addMessage(new BoopMessage("error.title","user.or.password.invalid",Severity.ERROR));
				 result.redirectTo(this).login();
				 return;
			 } else {
				 MessagesController.addMessage(new BoopMessage("success.login.title","success.login.message",Severity.SUCCESS));
				 result.redirectTo(HomeController.class).home();
				 return;
			 }
		} else {
			MessagesController.addMessage(new BoopMessage("error.title","user.inexistent",Severity.ERROR));
			result.redirectTo(this).login();
			return;
		}
	}

	@Get("/")
	public void login() {
	}
	
	@Get("/logout")
	public void sair() {
		usuarioLogado.setUsuario(null);
		result.redirectTo(this).login();
	}
}