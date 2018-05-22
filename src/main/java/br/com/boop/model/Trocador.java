package br.com.boop.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Trocador {
	
	@OneToMany
	private ArrayList<Livro> livros; 

}
