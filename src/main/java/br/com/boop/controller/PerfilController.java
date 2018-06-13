package br.com.boop.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PerfilController {
	private final UsuarioDao usuarioDao;
	private final Validator validator;
	private final Result result;
	
	@SuppressWarnings("unused")
	@Deprecated
	public PerfilController() {
		this(null, null, null);
	}

	@Inject
	public PerfilController(Result _result, Validator _validator, UsuarioDao _usuarioDao) {
		this.validator = _validator;
		this.result = _result;
		this.usuarioDao = _usuarioDao;
	}
	
	@Get("/user")
	public void perfil() {
	}
	
	@Post("/atualizar")
	public void atualizar(@Valid Usuario usuario) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).perfil();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("user.update.error.title", msg.getMessage(), msg.getSeverity()));
			}
			return;
		}
		usuarioDao.atualizar(usuario);
		MessagesController.addMessage(new BoopMessage("user.update.sucess.title", "user.update.sucess.message", Severity.INFO));
		result.redirectTo(this).perfil();
	}
}
