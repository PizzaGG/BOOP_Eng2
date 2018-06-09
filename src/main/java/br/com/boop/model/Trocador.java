package br.com.boop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Trocador extends Usuario{
	
	@OneToMany (cascade=CascadeType.ALL, targetEntity=Livro.class)
	@NotNull
	private @Valid List<Livro> livros;

	public Trocador(){
	}
	
	public Trocador(ArrayList<Livro> _livros) {
		this.livros=_livros;
	}
	
	public List<Livro> getLivros() {
		return livros;
	} 
	

}
