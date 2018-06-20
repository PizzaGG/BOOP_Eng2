package br.com.boop.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.model.Livro;
import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {
	
	private final Result result;
	private final LivroDao livroDao;
	
	@Inject
	public HomeController(Result _result, LivroDao _livroDao) {
		this.result=_result;
		this.livroDao = _livroDao;
	}
	
	@Deprecated
	public HomeController() {
		this(null,null);
	}
	
	@Get("/home")
	public void home(){
		List<Livro> lista = livroDao.listarLivrosUsuario(UsuarioLogado.getUsername());

		while(lista.size() > 3) {
			lista.remove(lista.get(0));
		}
		
		result.include("livros", lista);
	}	
}
