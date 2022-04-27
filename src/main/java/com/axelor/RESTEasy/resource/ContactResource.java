package com.axelor.RESTEasy.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.RESTEasy.db.Contact;
import com.axelor.RESTEasy.service.ContactService;
import com.google.inject.Inject;

@Path("contact")
public class ContactResource {
	
	@Inject
	  ContactService cs;

	  @GET
	  @Path("/get/{cid}")
	  public View getContactByid(@PathParam("cid") Integer cid) {
		  Contact contact = cs.contactById(cid);
			System.out.println("View getContactByid  :: " + contact.getContact() /* + contact.getContactType() */);
	    return new View("/contactView.jsp", contact, "contactObj");
	  }

	  @POST
	  @Path("/update")
	  public void updateContact(@Context HttpServletResponse response,   @Context HttpServletRequest request) throws IOException {

	    Integer id = Integer.parseInt(request.getParameter("id"));
	   // String contactType = request.getParameter("contactType");
	    String contact = request.getParameter("contact");

		Contact c = new Contact(id, /* contactType, */ contact);
	    cs.updateContact(c);
	    response.sendRedirect(request.getContextPath() + "/person/get");
	  }

	  @GET
	  @Path("/delete/{id}")
	  public void deleteContact(@PathParam("id") Integer id, @Context HttpServletResponse response,
	      @Context HttpServletRequest request) throws IOException 
	  {
	    cs.deleteContactById(id);
	    response.sendRedirect(request.getContextPath() + "/person/get");
	  }

}
