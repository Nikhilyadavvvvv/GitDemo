package com.gym.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", "
				+ "address="+ address + ", mobile=" + mobile + ", email=" + email + ", membershipplan=" + membershipplan + "]";
	}

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long cusId;
	    @Column
	    @NotBlank(message = "Name is mandatory")
	    @Size(min=2, max=30, message = "Name should be between 2 and 30 characters")
	    @Pattern(regexp="^[a-zA-Z ]*$", message = "Name should only contain letters and spaces")
	    private String name;


	    @Column
	    @Min(value = 10, message = "Age should not be less than 10")
	    @Max(value = 80, message = "Age should not be greater than 80")
	    private int age;

	    @Column
	    @NotBlank(message = "Gender is mandatory")
	    @Pattern(regexp="^(male|female|others)$", message = "Gender should be either male, female, or others")
	    private String gender;


	    @Column
	    @NotBlank(message = "Address is mandatory")
	    private String address;

	    @Column
	    @NotBlank(message = "Mobile number is mandatory")
	    @Pattern(regexp="^[0-9]{10}$", message= "The mobile number must be exactly 10 digits")
	    private String mobile;



	    @Column
	    @Email(message = "Email should be valid")
	    private String email;


	    @Column
	    @NotBlank(message = "Membership plan is mandatory")
	    private String membershipplan;


	@Column
	
	public String getMembershipplan() {
		return membershipplan;
	}

	public void setMembershipplan(String membershipplan) {
		this.membershipplan = membershipplan;
	}

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Customer() {

	}
}
