package com.axelor.RESTEasy.service;

import java.util.List;

import com.axelor.RESTEasy.db.Person;

public interface PersonService {

	public boolean addPerson(Person p);
	public List<Person> getAllPersons();
	public boolean updatePerson(int personId, String personName,String contactNumber);
	
	public boolean deletePersonById(Integer id);
	  public Person getPersonById(Integer id) ;
	
	
}
