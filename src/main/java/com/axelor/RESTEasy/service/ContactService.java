package com.axelor.RESTEasy.service;

import com.axelor.RESTEasy.db.Contact;

public interface ContactService {

	public Contact contactById(Integer id);
	public boolean updateContact(Contact number);
	public boolean deleteContactById(Integer id);
}
