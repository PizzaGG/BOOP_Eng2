package br.com.boop.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class Trocador extends Usuario{
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Livro.class)
	private @Valid ArrayList<Livro> livros;

	public Trocador(){
	}
	
	public Trocador(ArrayList<Livro> _livros) {
		this.livros=_livros;
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	} 
	

}
