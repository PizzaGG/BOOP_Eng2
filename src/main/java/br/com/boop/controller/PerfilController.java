package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.dao.ImagemDao;
import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.BoopMessage;
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
public class PerfilController {
	private final UsuarioDao usuarioDao;
	private final Validator validator;
	private final Result result;
	
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
	
	//TODO: Fazer correção nos parâmetros
	@Post("/editarPerfil")
	public void atualizar(String username, Long matricula, String nome, String email, String senha, UploadedFile imagem) {
		if (validator.hasErrors()) {
			for (Message msg : validator.getErrors()) {
				MessagesController.addMessage(new BoopMessage("error.title", msg.getMessage(), msg.getSeverity()));
			}
			validator.onErrorForwardTo(this).perfil();
			return;
		}
		Usuario usu = UsuarioLogado.getUsuarioStatic();
		usu.setUsername(username);
		usu.setEmail(email);
		if(senha!=null)
			usu.setHashSenha(HashPasswordGenerator.getHashSha256(senha));
		usu.setMatricula(matricula);
		usu.setNome(nome);
		usuarioDao.atualizar(usu);
		ImagemDao.salva(imagem, usu);
		MessagesController.addMessage(new BoopMessage("success.title", "user.update.success.message", Severity.INFO));
		result.redirectTo(this).perfil();
	}
}
