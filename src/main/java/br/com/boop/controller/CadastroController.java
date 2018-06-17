package br.com.boop.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Livro;
import br.com.boop.model.Usuario;
import br.com.boop.util.HashPasswordGenerator;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Resource
public class CadastroController {

	private final LivroDao livroDao;
	private final UsuarioDao usuarioDao;
	private final Validator validator;
	private final Result result;
	
	@Deprecated
	public CadastroController() {
		this(null, null, null, null);
	}
	
	@Inject
	public CadastroController(Result _result, Validator _validator, LivroDao _livroDao, UsuarioDao _usuarioDao) {
		this.validator = _validator;
		this.result = _result;
		this.livroDao = _livroDao;
		this.usuarioDao = _usuarioDao;
	}
	
	@Get("/cadbook")
	public void cadastrarLivro() {
	}
	
	@Get("/caduser")
	public void cadastrarUsuario() {
	}
	
	@Post("/cadastrar")
	@UploadSizeLimit(sizeLimit=5 * 1024 * 1024, fileSizeLimit = 5 * 1024 * 1024)
	public void cadastrar(Livro livro, UploadedFile foto) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).cadastrarLivro();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("error.title", msg.getMessage(), msg.getSeverity()));
				result.redirectTo(CadastroController.class).cadastrarLivro();
			}
			return;
		}
		System.out.println(foto.getContentType());

//		livro.setSetImagem(foto);
		livroDao.salvar(livro);
		MessagesController.addMessage(new BoopMessage("sucess.title", "book.register.sucess.message", Severity.SUCCESS));
		result.redirectTo(HomeController.class).home();
		return;
	}
	
	@Post("/cadastrarUsuario")
	public void cadastroUsuario(Usuario usuario) {
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).cadastrarLivro();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("error.title", msg.getMessage(), msg.getSeverity()));
				result.redirectTo(LoginController.class).login();
			}
			return;
		}
		usuario.setHashSenha(HashPasswordGenerator.getHashSha256(usuario.getHashSenha()));
		usuarioDao.salvar(usuario);
		MessagesController.addMessage(new BoopMessage("success.title", "user.create.sucess.message", Severity.SUCCESS));
		result.redirectTo(LoginController.class).login();
		return;
	}
	
}
