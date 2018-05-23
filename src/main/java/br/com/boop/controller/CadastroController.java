package br.com.boop.controller;

import javax.inject.Inject;
import javax.validation.Valid;

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
public class CadastroController {
	private final LivroDao livroDao;
	private final Validator validator;
	private final Result result;

	@Deprecated
	private CadastroController() {
		this(null, null, null);
	}

	@Inject
	private CadastroController(Result _result, Validator _validator, LivroDao _livroDao) {
		this.validator = _validator;
		this.result = _result;
		this.livroDao = _livroDao;
	}
	
	@Get("/")
	public void index() {
	}
	
	@Post("/cadastrar")
	public void cadastrar(@Valid Livro livro,@Valid Integer idUsuario) {
		if (validator.hasErrors()) {
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("book.register.error", msg.getMessage(), msg.getSeverity().name().toString()));
			}
		}
		validator.onErrorForwardTo(this).index();
		livroDao.salvar(livro);
		MessagesController.addMessage(new BoopMessage("book.register.sucess", "book.register.sucess.message", Severity.SUCCESS.toString()));
		result.redirectTo(HomeController.class).index();
		
	}
	
}
