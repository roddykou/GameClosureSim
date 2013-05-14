package com.appspot.gameclosureinsim.databean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private String email;

	private int offer;

	private int receive;

	private int total;

	private String username;

	//bi-directional many-to-one association to Deal
//	@OneToMany(mappedBy="user1")
//	private List<Deal> deals1;
//
//	//bi-directional many-to-one association to Deal
//	@OneToMany(mappedBy="user2")
//	private List<Deal> deals2;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOffer() {
		return this.offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getReceive() {
		return this.receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<Deal> getDeals1() {
//		return this.deals1;
//	}
//
//	public void setDeals1(List<Deal> deals1) {
//		this.deals1 = deals1;
//	}
//
//	public List<Deal> getDeals2() {
//		return this.deals2;
//	}
//
//	public void setDeals2(List<Deal> deals2) {
//		this.deals2 = deals2;
//	}

}