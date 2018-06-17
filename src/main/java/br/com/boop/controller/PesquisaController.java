package br.com.boop.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.model.Livro;
import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class PesquisaController {

	private final Result result;
	@SuppressWarnings("unused")
	private final UsuarioLogado usuarioLogado;
	private final LivroDao livroDao;
	
	@Inject
	public PesquisaController(Result _result, UsuarioLogado _usuarioLogado, LivroDao _livroDao) {
		this.result=_result;
		this.usuarioLogado = _usuarioLogado;
		this.livroDao = _livroDao;
	}
	@Deprecated
	public PesquisaController() {
		this(null,null,null);
	}
	
	@Get("/pesq")
	public void pesquisa() {
	}

	public void todosLivros() {
	}
	
	@Get("/mybooks")
	public void listarLivrosDoUsuario() {
		List<Livro> lista = livroDao.listarLivrosUsuario(UsuarioLogado.getUsername());
		result.include("livros", lista);
		result.redirectTo(this).todosLivros();
	}

	@Post("/listar")
	public void listarLivrosDoSistema() {
		result.include("livros", livroDao.listarLivros());
		result.redirectTo(this).todosLivros();
	}
	
	@Post("/pesquisar")
	public void pesquisarLivros(String termo) {
		result.include("livros", livroDao.pesquisar(termo));
		result.redirectTo(this).pesquisa();
	}
	
}
