<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>--%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> -->
<body >
  	
<div align="center">
	<h1>CREATE USERS</h1><hr/>
	<form:form method="POST" modelAttribute="users">
		<form:input type="hidden" path="id" id="id"/>
		<table cellpadding="3">
			<tr>
				<td><label>Name: </label> </td>
				<td><form:input path="username" id="username"/></td>
				
		    </tr>
	    	
	    	<tr>
				<td><label>Password: </label> </td>
				<td><form:input type="password" path="password" id="password"/></td>
			
		    </tr>
		    <tr>
		    	<td><label>Role:</label></td>
		    	<td>
		    		<form:select path="role">
		    			<form:option value="manager">Manager</form:option>
		    			<form:option value="pos">POS</form:option>
		    		</form:select>
		    	</td>
		    </tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="ADD"/></td>	
			</tr>
		</table>
	</form:form>
</div>
</body> 