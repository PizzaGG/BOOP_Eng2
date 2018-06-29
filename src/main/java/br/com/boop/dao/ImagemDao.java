package br.com.boop.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import br.com.boop.model.Livro;
import br.com.boop.model.Usuario;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@RequestScoped
public class ImagemDao {
	
	private static File pastaImagens;
	
	public ImagemDao(ServletContext context) {
	    String caminhoImagens = context.getRealPath("/img");
	    pastaImagens = new File(caminhoImagens);
	    pastaImagens.mkdir();

    	System.out.println("no construtor");
	}
	
	public static void salva(UploadedFile imagem, Livro livro) {
	    File destino = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/l"+livro.getId() + ".img");
	    try {
	    	IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
	    } catch (IOException e) {
	      throw new RuntimeException("Erro ao copiar imagem", e);
	    }
	}
	
	public static void salva(UploadedFile imagem, Usuario usuario) {
	    File destino = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/u"+usuario.getId() + ".img");
	    try {
	    	IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
	    } catch (IOException e) {
	      throw new RuntimeException("Erro ao copiar imagem", e);
	    }
	}
	
	public static void salvaDefault(Usuario usuario) {
	    File destino = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/u"+usuario.getId() + ".img");
	    try {
	    	IOUtils.copy(getDefault(), new FileOutputStream(destino));
	    } catch (IOException e) {
	      throw new RuntimeException("Erro ao copiar imagem", e);
	    }
	}
	
	
	public static File mostra(Livro livro) {
		pastaImagens = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/");
		return new File(pastaImagens, "l" + livro.getId() + ".img");
	}
	
	public static File mostra(Long id) {
		pastaImagens = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/");
		return new File(pastaImagens, "u" + id + ".img");
	}
	
	public static FileInputStream getDefault() {
		pastaImagens = new File("/home/pizzagg/git/BOOP_Eng2/src/main/webapp/img/default.png");
		FileInputStream imagem = null;
		try {
			imagem = new FileInputStream(pastaImagens);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return imagem;
	}
	
}
