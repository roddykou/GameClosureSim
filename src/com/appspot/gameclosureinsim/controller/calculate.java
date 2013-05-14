package com.appspot.gameclosureinsim.controller;

import java.util.Iterator;
import java.util.List;

import com.appspot.gameclosureinsim.databean.User;
import com.appspot.gameclosureinsim.model.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class calculate extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int result[];
	
	public String execute(){
		UserService us = new UserService();
		List<User> list = us.getAllUsers();
		try{
		play(list);
		result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i).getTotal();
			System.out.println(result[i]);
		}
		/**
		 * truncate database;
		 */
		us.truncate();
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public void play(List<User> users) {
		User sendUser = new User();
		Iterator sendIt = users.iterator();
		while (sendIt.hasNext()) {
			sendUser = (User) sendIt.next();
			
			User receiveUser = new User();
			Iterator receiveIt = users.iterator();
			
			while (receiveIt.hasNext()) {
				receiveUser = (User) receiveIt.next();
				if (!receiveUser.equals(sendUser)) {
					
					if (sendUser.getOffer() >= receiveUser.getReceive()) {
						sendUser.setTotal( sendUser.getTotal() + (100 - sendUser.getOffer()));
						receiveUser.setTotal( receiveUser.getTotal() +sendUser.getOffer());

					}

				}
			}
		}
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}



	
}
