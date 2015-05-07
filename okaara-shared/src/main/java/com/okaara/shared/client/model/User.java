package com.okaara.shared.client.model;

public class User {

	private Integer id;
	private String email;
	private String name;
	private String password;

	public User() {
	}

	public User(Integer id, String email, String name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(String email, String password) {
		this(null, email, null, password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + " name=" + this.name + " password=" + this.password + " email=" + this.email + " ]";
	}

}
