package com.gym.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="membership")
public class MemberShip {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int msid;
	
	private String membership_name;
	private int price;
	@Column(columnDefinition="TEXT")
	private String description;
	public int getMsid() {
		return msid;
	}
	public void setMsid(int msid) {
		this.msid = msid;
	}
	public String getMembership_name() {
		return membership_name;
	}
	public void setMembership_name(String membership_name) {
		this.membership_name = membership_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

