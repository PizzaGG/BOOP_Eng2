package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {
	
	private Result result;

	@Inject
	public HomeController(Result result) {
		this.result = result;
	}
	
	@Deprecated
	public HomeController() {
		this(null);
	}

	@Get("/home")
	public void home(){
	}
	
	@Get("/sair")
	public void sair() {
		UsuarioLogado.setUsuario(null);
		result.redirectTo(LoginController.class).login();
	}
}
