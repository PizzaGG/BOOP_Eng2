package br.com.boop.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Trocador extends Usuario{
	
	@OneToMany
	@NotNull
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
