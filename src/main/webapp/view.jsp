<%@page import="com.axelor.RESTEasy.db.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title> view JSP </title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style.css">
	
<script type="text/javascript">
	var count = 1;
	function validateForm() {
		var x = document.forms["person"]["name"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
		
		var y = document.forms["person"]["contact[<%=0%>]" ].value;
		if (y == "") {
			alert("Contact must be filled out");
			return false;
		}
		
	} 
	
	function add(divName) {
		var newDiv = document.createElement('div');
		var selectHTML = '<br>Contact Number : <INPUT TYPE="TEXT" NAME="contact['+count+']" size="10" />';
		newDiv.innerHTML = selectHTML;
		document.getElementById(divName).appendChild(newDiv);
		count++;
		var setCount = document.getElementById("count");
		setCount.setAttribute("value", count);
	}
	function SelectElement(selectElementId, valueToSelect)
	{    
	    var element = document.getElementById(selectElementId);
	    element.value = valueToSelect;
	}
</script>
</head>
<body>
<center>
		<h3>Edit Form</h3>
		<%
		  Person p = (Person) request.getAttribute("PersonObj");
		%>
		<FORM ACTION="<%=request.getContextPath()%>/person/update" METHOD="POST" name="person">
			Person Id :<% out.print(" " + p.getId());%><br> <br>
			<INPUT TYPE="hidden" NAME="personId" VALUE="<%=p.getId()%>"> 
			 Name:<INPUT TYPE="TEXT" NAME="name" VALUE="<%=p.getName()%>"> <br>
			<% for(int i = 0; i <p.getContact().size(); i++) { %>
				<br> 
				Contact Numbers:
				<INPUT TYPE="VARCHAR" NAME="contact[<%=i%>]" 	value="<%=p.getContact().get(i).getContact()%>" />
				<INPUT TYPE="hidden" NAME="contactId" VALUE="<%=p.getContact().get(i).getId()%>"> 
				<br>
				<br>
		<% } %>
			<br>
			<INPUT TYPE="SUBMIT" VALUE="SUBMIT" />
		</FORM>
	</center>
</body>
</html>