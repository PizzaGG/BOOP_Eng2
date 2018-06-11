package br.com.boop.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Livro;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Resource
public class CadastroController {

	private final LivroDao livroDao;
	private final Validator validator;
	private final Result result;
	
	@SuppressWarnings("unused")
	@Deprecated
	public CadastroController() {
		this(null, null, null);
	}
	
	@Inject
	public CadastroController(Result _result, Validator _validator, LivroDao _livroDao) {
		this.validator = _validator;
		this.result = _result;
		this.livroDao = _livroDao;
	}
	
	@Get("/cadastro")
	public void cadastrarLivro() {
	}
	
	@Post("/cadastrar")
	public void cadastrar(Livro livro) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).cadastrarLivro();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("user.update.error.title", msg.getMessage(), msg.getSeverity()));
				result.redirectTo(LoginController.class).login();
			}
			return;
		}
		livroDao.salvar(livro);
		MessagesController.addMessage(new BoopMessage("user.update.sucess.title", "user.update.sucess.message", Severity.INFO));
		result.redirectTo(HomeController.class).home();
		return;
	}
	
}
