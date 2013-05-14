package com.appspot.gameclosureinsim.controller;

import com.appspot.gameclosureinsim.databean.User;
import com.appspot.gameclosureinsim.model.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class playersignup extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private int offer;
	private int receive;
	private String feedback;
	
	public String execute(){
		UserService us = new UserService();
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setOffer(offer);
		user.setReceive(receive);
		
		try{
			us.createUser(user);
			feedback = "waiting for result";
			
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
