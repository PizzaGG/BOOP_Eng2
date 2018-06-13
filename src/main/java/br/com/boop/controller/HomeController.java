package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {
	
	private Result result;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public HomeController(Result result, UsuarioLogado usuarioLogado) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Deprecated
	public HomeController() {
		this(null, null);
	}

	@Get("/home")
	public void home(){
	}
	
	@Get("/sair")
	public void sair() {
		//usuarioLogado.setUsuario(null);
		result.redirectTo(LoginController.class).login();
	}
}
