package com.gym.model;

import jakarta.validation.constraints.NotEmpty;

public class MemberShipDto {
	@NotEmpty(message="Required")
	private String membership_name;
	@NotEmpty(message="Required")
	private int price ;
	@NotEmpty(message="Required")
	private String description;
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