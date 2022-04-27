<%@page import="com.axelor.RESTEasy.db.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact view</title>
</head>
<body>

	<center>
		<h3>Edit Form</h3>
		<%
		Contact contact = (Contact) request.getAttribute("contactObj");
		%>

		<FORM ACTION="<%=request.getContextPath()%>/contact/update"  METHOD="POST">
			Contact Id :<%out.print(" " + contact.getId());%><br> <br>
			<INPUT TYPE="hidden" NAME="id" VALUE="<%=contact.getId()%>"> 
			
			Contact Number:<INPUT TYPE="TEXT" NAME="contact" value="<%=contact.getContact()%>" /> <br> <br> 
			
			<!-- Contact Type:
			<SELECT name="contactType">
			 	<option value="contact type" selected disabled>--Select Type--</option>
				<OPTION value="Personal">Personal</OPTION>
				<OPTION value="College">College</OPTION>
				<OPTION value="Work">Work</OPTION>
				<OPTION value="Others">Others</OPTION>
			</SELECT> <br>
			<br> 
 -->			
			<INPUT
			TYPE="SUBMIT" VALUE="SUBMIT" />


		</FORM>
	</center>

</body>
</html>