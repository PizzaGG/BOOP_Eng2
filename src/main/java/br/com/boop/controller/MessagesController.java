package br.com.boop.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.boop.model.BoopMessage;

@Named
@SessionScoped
public class MessagesController implements Serializable {

	private static final long serialVersionUID = 5767500124744267839L;
	
	private static ArrayList<BoopMessage> messagesList = new ArrayList<BoopMessage>();
	
	

	
	public ArrayList<BoopMessage> getMessagesList() {
		return messagesList;
	}


	public static void addMessage(BoopMessage boopMessage) {
		messagesList.add(boopMessage);
	}
	
	public static void clear() {
		messagesList.clear();
	}
	
	
	
}
