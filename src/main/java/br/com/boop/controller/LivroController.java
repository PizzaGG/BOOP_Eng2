package br.com.boop.controller;


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
public class LivroController {
	private LivroDao livroDao;
	private Validator validator;
	private Result result;

	@Inject
	private LivroController(Result result, Validator validator, LivroDao livroDao) {
		this.validator = validator;
		this.result = result;
		this.livroDao = livroDao;
	}
	
	@Deprecated
	private LivroController() {
		this(null, null, null);
	}
	
	@Get("/livro")
	public void livro(){
	}
	
	@Post("/cadastrar")
	public void cadastrar(Livro livro) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(HomeController.class).home();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("book.register.error.title", msg.getMessage(), msg.getSeverity()));
			}
			return;
		}
		livroDao.salvar(livro);
		MessagesController.addMessage(new BoopMessage("book.register.sucess.title", "book.register.sucess.message", Severity.INFO));
		result.redirectTo(HomeController.class).home();
	}
	
	@Post("/atualizar")
	public void atualizar(Livro livro) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(HomeController.class).home();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("book.register.error.title", msg.getMessage(), msg.getSeverity()));
			}
			return;
		}
		livroDao.atualizar(livro);
		MessagesController.addMessage(new BoopMessage("book.register.sucess.title", "book.register.sucess.message", Severity.INFO));
		result.redirectTo(HomeController.class).home();
	}
	
	public void deletar(Long idLivro) {
		livroDao.deletar(idLivro);
		MessagesController.addMessage(new BoopMessage("book.register.sucess.title", "book.register.sucess.message", Severity.INFO));
		result.redirectTo(HomeController.class).home();
	}
	
}
