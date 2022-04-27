package com.axelor.RESTEasy.db;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String contact;
	//private String contactType;
	
	public Contact() {}
	
	public Contact(/* String contactType, */ String contact) {  

	    //this.contactType = contactType;
	    this.contact = contact;
	  }

		public Contact(Integer id, /* String contactType, */ String contact) { 
	    this.id = id;
	    //this.contactType = contactType;
	    this.contact = contact;
	  }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
//	public String getContactType() {
//		return contactType;
//	}
//	public void setContactType(String contactType) {
//		this.contactType = contactType;
//	}
}