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
	private UsuarioLogado usuarioLogado;
	private final UsuarioDao usuarioDao;

	@Inject
	public LoginController(Result result, UsuarioLogado usuarioLogado,
			UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
	}

	@Deprecated
	public LoginController() {
		this(null, null, null);
	}

	@Post("/auth")
	public void autentica(String user, String pass) {
		if (usuarioLogado != null) {
			MessagesController
					.addMessage(new BoopMessage("has.logged.user.tittle", "has.loggued.user.message", Severity.WARN));
			result.redirectTo(HomeController.class).home();
			return;
		}
		if (usuarioDao.hasUser(user)) {
			 usuarioLogado = usuarioDao.login(user,HashPasswordGenerator.getHashSha256(pass));
			 if (usuarioLogado==null) {
				 MessagesController.addMessage(new BoopMessage("error.tittle","user.or.password.invalid",Severity.ERROR));
				 result.redirectTo(this).login();
				 return;
			 } else {
				 MessagesController.addMessage(new BoopMessage("sucess.tittle","sucess.login.tittle",Severity.SUCCESS));
				 result.redirectTo(HomeController.class).home();
				 return;
			 }
		}
	}

	@Get("/")
	public void login() {
	}
}