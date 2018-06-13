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

	@Inject
	public LoginController(Result result,
			UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}

	@Deprecated
	public LoginController() {
		this(null, null);
	}

	@Post("/auth")
	public void autentica(Long usuario, String senha) {
		if (UsuarioLogado.getUsuario() != null) {
			MessagesController
					.addMessage(new BoopMessage("has.logged.user.title", "has.logged.user.message", Severity.WARN));
			result.redirectTo(HomeController.class).home();
			return;
		}
		if (usuarioDao.existe(usuario)) {
			 UsuarioLogado.setUsuario(usuarioDao.login(usuario, HashPasswordGenerator.getHashSha256(senha)));
			 if (UsuarioLogado.getUsuario()==null) {
				 MessagesController.addMessage(new BoopMessage("error.title","user.or.password.invalid",Severity.ERROR));
				 result.redirectTo(this).login();
				 return;
			 } else {
				 MessagesController.addMessage(new BoopMessage("sucess.title","sucess.login.title",Severity.SUCCESS));
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
}