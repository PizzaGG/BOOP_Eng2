package br.com.boop.controller;

import javax.inject.Inject;

import br.com.boop.dao.LivroDao;
import br.com.boop.dao.TrocaDao;
import br.com.boop.dao.UsuarioDao;
import br.com.boop.model.Livro;
import br.com.boop.model.Troca;
import br.com.boop.model.Usuario;
import br.com.boop.model.enumerables.Status;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class TrocaController {
	
	private final Result result;
	private final Validator validator;
	private final TrocaDao trocaDao;
	private final UsuarioDao usuarioDao;
	private final LivroDao livroDao;
	
	@Inject
	public TrocaController(Result result, Validator validator, TrocaDao trocaDao, UsuarioDao usuarioDao, LivroDao livroDao) {
		this.validator = validator;
		this.result = result;
		this.trocaDao = trocaDao;
		this.usuarioDao = usuarioDao;
		this.livroDao = livroDao;
	}
	
	@Deprecated
	public TrocaController() {
		this(null, null, null, null, null);
	}
	
	@Get("/troca")
	public void troca() {
	}
	
	@Post("/novaTroca")
	public void novaTroca(Long userOrig, Long userDest, Long livro) {
		System.out.println(livro);
		System.out.println(userDest);
		System.out.println(userOrig);
		Troca t = new Troca();
		t.setDestinatario(usuarioDao.busca(userDest));
		t.setOriginario(usuarioDao.busca(userOrig));
		t.setLivroSolicitado(livroDao.busca(livro));
		t.setStatusDoPedido(Status.SOLICITADO);
		trocaDao.salvar(t);
		result.redirectTo(this).troca();
	}
}
