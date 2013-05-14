package com.appspot.gameclosureinsim.databean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Deals database table.
 * 
 */
@Entity
@Table(name="Deals")
public class Deal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dealid;

	private int receiveget;

	private int sendget;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="sendid")
//	private User user1;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="receiveid")
//	private User user2;

	public Deal() {
	}

	public int getDealid() {
		return this.dealid;
	}

	public void setDealid(int dealid) {
		this.dealid = dealid;
	}

	public int getReceiveget() {
		return this.receiveget;
	}

	public void setReceiveget(int receiveget) {
		this.receiveget = receiveget;
	}

	public int getSendget() {
		return this.sendget;
	}

	public void setSendget(int sendget) {
		this.sendget = sendget;
	}

//	public User getUser1() {
//		return this.user1;
//	}
//
//	public void setUser1(User user1) {
//		this.user1 = user1;
//	}
//
//	public User getUser2() {
//		return this.user2;
//	}
//
//	public void setUser2(User user2) {
//		this.user2 = user2;
//	}

}