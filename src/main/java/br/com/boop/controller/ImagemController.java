package br.com.boop.controller;

import java.io.File;

import javax.annotation.Resource;

import br.com.boop.dao.ImagemDao;
import br.com.boop.model.Livro;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
@Resource
public class ImagemController {

	@Get("/imagem/livro/{livro.id}")
	public File download(Livro livro) {
		System.out.println("alo l: "+livro.getId());
	  return ImagemDao.mostra(livro);
	}
	
	@Get("/imagem/usuario/{id}")
	public File downloadUsuario(Long id) {
		System.out.println("alo u: "+id);
	  return ImagemDao.mostra(id);
	}
	
}
