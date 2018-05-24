package br.com.boop.model;

import br.com.caelum.vraptor.validator.Severity;

public class BoopMessage {

	private String category;
	private String message;
	private Severity type;
	
	public BoopMessage(String _category, String _message, Severity success) {
		this.category = _category;
		this.message = _message;
		this.type = success;
	}

	public String getCategory() {
		return category;
	}

	public String getMessage() {
		return message;
	}

	public Severity getType() {
		return type;
	}
	
	

}
