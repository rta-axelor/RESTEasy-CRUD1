<%@page import="com.axelor.RESTEasy.db.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title> Home </title>

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
		
		var y = document.forms["person"]["contact[0]"].value;
		if (y == "") {
			alert("Contact must be filled out");
			return false;
		}
		
		
		/* var z = document.forms["person"]["contactType[0]"].value;
		if (z == "contacttype") {
			alert("please select contact type");
			return false;
		} */
		
	} 
	
	function add(divName) {
		var newDiv = document.createElement('div');
		var selectHTML = '<br>Contact number : <INPUT TYPE="NUMBER" NAME="contact['+count+']" size="10" />';
		selectHTML += '<SELECT name="contact['+count+']"> <OPTION value="Personal">Personal</OPTION><OPTION value="College">College</OPTION><OPTION value="Work">Work</OPTION> <OPTION value="Others">Others</OPTION></SELECT> ';
		newDiv.innerHTML = selectHTML;
		document.getElementById(divName).appendChild(newDiv);
		count++;
		var setCount = document.getElementById("count");
		setCount.setAttribute("value", count);
	}
</script>

</head>

<body>
<h1>Rest-Easy Demo of Contact Book</h1>
<br><br><br>
<center>
	<FORM ACTION="<%=request.getContextPath()%>/person/insert"  METHOD="POST" name="person" onsubmit="return validateForm();" >
		<fieldset >
			<legend> Insert Person </legend>
			<br><br>
			 Name :&nbsp; <INPUT TYPE="TEXT" NAME="name" size="20"> <br><br>
			 Contact Number: &nbsp;<INPUT 	TYPE="NUMBER" NAME="contact[0]" size="10" /> 
			<!--  <SELECT name="contactType[0]">
				<OPTION value="contacttype" selected disabled>--Select Type--</OPTION>
				<OPTION value="Personal">Personal</OPTION>
				<OPTION value="College">College</OPTION>
				<OPTION value="Work">Work</OPTION>
				<OPTION value="Others">Others</OPTION>
			</SELECT>  -->
			
			<!-- <INPUT type="button" value="Add" onclick="add('dynamicInput')" /> <br> -->
		<div id="dynamicInput"></div> 
			
			<br><br>
			<INPUT type="submit" value="submit" /> <br>
		</fieldset>
		
		 <input type="hidden" id="count" name="count" value="1">
	</form>
	<br>
	<br>
	<br>
	

	<%-- 	</center> --%>
	<br>
	
	
	<br><br>
		<table border="1">
			<tr>
				<th>Person ID</th>
				<th>Person Name</th>
				<th>Person Contact Number</th>
				<th>Action Edit</th>
				<th>Action Delete</th>
				
			</tr>
			
			
			<c:forEach items="${personList}" var="person"> ${Contact.contact}   
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td> <c:forEach items="${person.contact}" var="Contact"> ${Contact.contact}   
					
					<br>
			</c:forEach>
			</td>

			<td><a href="<%=request.getContextPath()%>/person/get/${person.id}">Edit</a></td>
			<td><a href="<%=request.getContextPath()%>/person/delete/${person.id}"
				onclick="return window.confirm('Are you sure ?')">Delete</a>
				
				
				

				</tr>
			</c:forEach>
			
			
		</table>
		<br>
		
	</center>


</body>
</html>