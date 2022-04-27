package com.axelor.RESTEasy.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.RESTEasy.db.Contact;
import com.axelor.RESTEasy.db.Person;
import com.axelor.RESTEasy.service.PersonService;
import com.google.inject.Inject;



@Path("person")
public class PersonResources {
	
	@Inject
	PersonService ps;
	
	@POST
	@Path("/insert")
	public void addPerson(@Context HttpServletResponse response, @Context HttpServletRequest request) throws IOException {

		int count = Integer.parseInt(request.getParameter("count"));
	    List<Contact> list = new ArrayList<Contact>();
		String /* contactType, */ contact	;

	    for (int i = 0; i < count; i++) {
	    	//contactType = request.getParameter("contactType[" + i + "]");
	    	contact = request.getParameter("contact[" + i + "]");
			list.add(new Contact(/* contactType, */contact));
	    }
	    
	    Person p = new Person(request.getParameter("name") , list);

	    ps.addPerson(p);
	    response.sendRedirect(request.getContextPath() + "/person/get");
  }
	@GET
	  @Path("/get")
	  public View getAllPersons() {
	    List<Person> list = ps.getAllPersons();
	    return new View("/index.jsp",  list,"personList");
	  }
	  
	  @GET
	  @Path("/get/{id}")
	  public View getPersonById(@Context HttpServletResponse response, @Context HttpServletRequest request, @PathParam("id") Integer id) {
		  Person p = ps.getPersonById(id);
	    System.out.println(  "PersonResources.getPersonById ::" + p.getName() + p.getContact() + p.getContact().size());
	    return new View("/view.jsp", p, "PersonObj");
	  }

	  @POST
	  @Path("/update")
	  public void updatePerson(@Context HttpServletResponse response,   @Context HttpServletRequest request) throws IOException 
	  {
//		  int l = Integer.parseInt(request.getParameter("count"));
//		  List<Contact> list = new ArrayList<Contact>();
//		  
//		  for (int i = 0; i < l; i++) {
//				list.add(new Contact(
//						/* request.getParameter("contactType[" + i + "]"), */ request.getParameter("contact[" + i + "]")));
//		  	}
		  
		  int personId = Integer.parseInt(request.getParameter("personId"));
//		  int contactId = Integer.parseInt(request.getParameter("contactId"));
	    String personName = request.getParameter("name");
	    String contactNum = request.getParameter("contact[0]");
//	    Person p = new Person(name,list);
	    
	    ps.updatePerson(personId,personName,contactNum);
	    response.sendRedirect(request.getContextPath() + "/person/get");
	  }
	  
	  @GET
	  @Path("/delete/{id}")
	  public void deletePerson(@PathParam("id") Integer id, @Context HttpServletResponse response, @Context HttpServletRequest request) throws IOException 
	  {
	    ps.deletePersonById(id);
	    response.sendRedirect(request.getContextPath() + "/person/get");
	  }

	
}
