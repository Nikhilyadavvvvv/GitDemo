package com.gym.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public  class Feedback {
  @Id
  @Column
  @NotBlank(message = "Name is required")
  private String name;

  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")
@Column
private String email;
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


@NotBlank(message = "Feedback is required")
@Column
private String feedback;
public String getFeedback() {
	return feedback;
}

public void setFeedback(String feedback) {
	this.feedback = feedback;
}



}

