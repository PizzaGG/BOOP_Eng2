package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Livro;
import br.com.boop.model.UsuarioLogado;
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
	public LivroController(Result result, Validator validator, LivroDao livroDao) {
		this.validator = validator;
		this.result = result;
		this.livroDao = livroDao;
	}
	
	@Deprecated
	public LivroController() {
		this(null, null, null);
	}
	
	@Get("/change")
	public void trocar() {
	}
	
	public void livro() {
	}
	
	@Post("/livro")
	public void verLivro(String isbn){
		Livro livro = livroDao.busca(isbn);
		result.include("livro", livro);
		result.redirectTo(this).livro();
	}
	
	@Post("/editarLivro")
	public void editarLivro(Livro livro, String isbnOld) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(HomeController.class).home();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("book.register.error.title", msg.getMessage(), msg.getSeverity()));
			}
			return;
		}
		livro.setProprietario(UsuarioLogado.getUsuarioStatic());
		livroDao.atualizar(livro, isbnOld);
		MessagesController.addMessage(new BoopMessage("success.title", "book.update.success.message", Severity.INFO));
		result.include("livro", livro);
		result.redirectTo(this).livro();
	}
	
	@Get("/delete")
	public void deletar(Livro livro) {
		livroDao.deletar(livro.getId());
		MessagesController.addMessage(new BoopMessage("success.title", "book.delete.success.message", Severity.INFO));
		result.redirectTo(HomeController.class).home();
	}
}
