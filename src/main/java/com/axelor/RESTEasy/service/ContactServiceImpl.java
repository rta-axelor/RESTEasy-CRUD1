package com.axelor.RESTEasy.service;

import javax.persistence.EntityManager;

import com.axelor.RESTEasy.db.Contact;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContactServiceImpl implements ContactService{

	@Inject
	Provider<EntityManager> emp;
	
	@Override
	public Contact contactById(Integer id) {

		EntityManager em = emp.get();
		Contact contact = em.find(Contact.class, id);
	    return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		
		EntityManager em = emp.get();
		System.out.println("ContactServiceImpl.updateContact" + contact.getContact()/* + contact.getContactType() */);
	    Contact c = em.find(Contact.class, contact.getId());
	    c.setContact(contact.getContact());
	   // c.setContactType(contact.getContactType());
	    return true;
	}

	@Override
	public boolean deleteContactById(Integer id) {
		EntityManager em = emp.get();
		Contact contact = em.find(Contact.class, id);
	    em.remove(contact);
	    return true;
	}

}
