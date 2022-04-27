package com.axelor.RESTEasy.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Person {
	
	
	
	@Id
    @GeneratedValue	(strategy = GenerationType.IDENTITY)   
	Integer id;
	String name;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)  
	@JoinColumn(name = "contact_id")
	private List<Contact> contact = new ArrayList<Contact>();


	public Person() {
	}

	public Person(String name, List<Contact> contact) {
	this.name = name;
	this.contact=contact;
	
	
	
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

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}



	@Override
	public String toString() {
		return this.name;
	}
}
