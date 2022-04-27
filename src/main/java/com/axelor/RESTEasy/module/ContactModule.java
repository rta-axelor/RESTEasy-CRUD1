package com.axelor.RESTEasy.module;


import com.axelor.RESTEasy.resource.ContactResource;
import com.axelor.RESTEasy.resource.PersonResources;

import com.axelor.RESTEasy.service.ContactService;
import com.axelor.RESTEasy.service.ContactServiceImpl;
import com.axelor.RESTEasy.service.PersonService;
import com.axelor.RESTEasy.service.PersonServiceImpl;
import com.google.inject.AbstractModule;

public class ContactModule extends AbstractModule {

	@Override
	  protected void configure() {

	    bind(PersonResources.class);
	    bind(ContactResource.class);
	   
	    bind(PersonService.class).to(PersonServiceImpl.class);
	    bind(ContactService.class).to(ContactServiceImpl.class);
	  
	  }
	  	
}
