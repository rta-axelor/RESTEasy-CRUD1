package com.axelor.RESTEasy.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.axelor.RESTEasy.db.Person;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class PersonServiceImpl implements PersonService{

	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	@Override
	public boolean addPerson(Person p) {
		
		EntityManager em = emp.get();
		em.persist(p);
		return true;
	}

	@Transactional
	@Override
	public List<Person> getAllPersons() {
		
		EntityManager em = emp.get();
		List<Person> personList = em.createQuery("from Person", Person.class).getResultList();
		return personList;
	}
	
	@Transactional
	@Override
	public Person getPersonById(Integer id) {
		
		EntityManager em = emp.get();
		Person p = em.find(Person.class, id);
		return p;
	}

	@Transactional
	@Override
	public boolean updatePerson(int personId, String personName,String contactNum) {
		
		 EntityManager em = emp.get();
		 Person person = em.find(Person.class, personId);
		 person.setName(personName);

		 person.getContact().get(0).setContact(contactNum);
		 em.merge(person);
		 
		    return true;
	}

	@Transactional
	@Override
	public boolean deletePersonById(Integer id) {
	
		EntityManager em = emp.get();
	    Person person = em.find(Person.class, id);
	    em.remove(person);
	    return true;
	}


}
