package br.com.boop.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import br.com.boop.dao.ImagemDao;
import br.com.boop.dao.LivroDao;
import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Boopoint;
import br.com.boop.model.Livro;
import br.com.boop.model.Usuario;
import br.com.boop.model.UsuarioLogado;
import br.com.boop.util.HashPasswordGenerator;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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
	private final UsuarioLogado usuarioLogado;
	
	@Deprecated
	public CadastroController() {
		this(null, null, null, null, null);
	}
	
	@Inject
	public CadastroController(Result _result, Validator _validator, LivroDao _livroDao, UsuarioDao _usuarioDao, 
			UsuarioLogado _usuarioLogado) {
		this.validator = _validator;
		this.result = _result;
		this.livroDao = _livroDao;
		this.usuarioDao = _usuarioDao;
		this.usuarioLogado = _usuarioLogado;
	}
	
	@Get("/cadbook")
	public void cadastrarLivro() {
	}
	
	@Get("/caduser")
	public void cadastrarUsuario() {
	}
	
	@Get("/imgTeste")
	public void imagemTeste() {
	}
	
	@Post("/imgUp")
	public void imgUp(UploadedFile imagem){
		System.out.print(imagem);
	    System.out.print(imagem.getFileName());
	}
	
	@Post("/cadastrar")
	public void cadastrar(Livro livro, UploadedFile imagem) {
		
		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).cadastrarLivro();
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("error.title", msg.getMessage(), msg.getSeverity()));
				result.redirectTo(CadastroController.class).cadastrarLivro();
			}
			return;
		}
		livro.setProprietario(usuarioLogado.getUsuario());
		livroDao.salvar(livro);
		ImagemDao.salva(imagem, livro);
		MessagesController.addMessage(new BoopMessage("success.title", "book.register.success.message", Severity.SUCCESS));
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
		usuario.setBooPoint(new Boopoint(usuario,1,0));
		usuarioDao.salvar(usuario);
		ImagemDao.salvaDefault(usuario);
		MessagesController.addMessage(new BoopMessage("success.title", "user.create.success.message", Severity.SUCCESS));
		result.redirectTo(LoginController.class).login();
		return;
	}
	
}
