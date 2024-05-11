package com.example.SpringBatch.POJO;

public class EmployeeCsv {
	String id;
	String name;
	String email;
	String place;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "EmployeeCsv [id=" + id + ", name=" + name + ", email=" + email + ", place=" + place + "]";
	}

}
