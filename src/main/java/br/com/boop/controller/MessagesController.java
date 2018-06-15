package br.com.boop.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.boop.model.BoopMessage;

@Named("msg")
@SessionScoped
public class MessagesController implements Serializable {

	private static final long serialVersionUID = 5767500124744267839L;
	
	private static ArrayList<BoopMessage> webMessagesList = new ArrayList<BoopMessage>();
	
	public static ArrayList<BoopMessage> getMessagesList() {
		return webMessagesList;
	}

	public static void addMessage(BoopMessage boopMessage) {
		webMessagesList.add(boopMessage);
	}
	
	public static void clear() {
		webMessagesList.clear();
	}
	
	public static void getUserMessages() {
	}
	
	
	
}
