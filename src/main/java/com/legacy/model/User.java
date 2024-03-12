package com.legacy.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "users")
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String document;
	private String email;
	
	public User() {
	}

	public User(String id, String firstName, String lastName, String document, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.document = document;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
