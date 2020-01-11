package com.deloitte.model;

public class User {
	private Long id;
	private String pass, name, gender, country;
	public User(Long id, String pass, String name, String gender, String country) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.gender = gender;
		this.country = country;
	}
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", gender=" + gender + ", country=" + country
				+ "]";
	}
}