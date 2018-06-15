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
	
	/**
	 * Carrega a pagina inicial da pesquisa. Já passa para a request os livros do banco.
	 */
	@Get("/pesq")
	public void pesquisa() {
		List<Livro> lista = livroDao.listarLivros();
		result.include("lista",lista);
	}
	
	/**
	 * Metodo que retorna todos os livros do usuario da seção;
	 */
	@Post("/mybooks")
	public void listarLivrosDoUsuario() {
	}
	
	/**
	 * Metodo que retorna os livros disponiveis para troca no sistema;
	 */
	@Post("/listar")
	public void listarLivrosDoSistema() {
	}
	
	/**
	 * Metodo que retorna os livros encontrados que fazem parte do termo de pesquisa inserido.
	 */
	@Post("/pesquisar")
	public void pesquisarLivros() {
	}
	
}
