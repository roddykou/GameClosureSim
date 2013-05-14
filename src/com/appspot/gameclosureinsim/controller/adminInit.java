package com.appspot.gameclosureinsim.controller;

import java.util.List;

import com.appspot.gameclosureinsim.databean.User;
import com.appspot.gameclosureinsim.model.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class adminInit extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> curUsers;
	
	public String execute(){
		UserService us = new UserService();
		curUsers = us.getAllUsers();
		return SUCCESS;
	}

	public List<User> getCurUsers() {
		return curUsers;
	}

	public void setCurUsers(List<User> curUsers) {
		this.curUsers = curUsers;
	}
}
