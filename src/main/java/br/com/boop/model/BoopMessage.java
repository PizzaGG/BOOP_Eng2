package br.com.boop.model;

public class BoopMessage {

	private String category;
	private String message;
	private String type;
	
	public BoopMessage(String _category, String _message, String _type) {
		this.category = _category;
		this.message = _message;
		this.type = _type;
	}

	public String getCategory() {
		return category;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}
	
	

}
