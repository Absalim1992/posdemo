 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<body>
<div align="center">
<h1>TAXES MENU</h1><hr>

<form:form method="POST" modelAttribute="taxes">
    <form:input type="hidden" path="id" id="id"/>
    <form:input type="hidden" path="status" id="status" value="ACTIVE"/>
    
    <table cellpadding="3">
    <tr>
    	<td><label>Tax ID:</label></td>
    	<td><form:input path="taxid" id="taxid"/></td>
    </tr>
	<tr>
		<td><label>Tax Name:</label></td>
		<td><form:input path="taxname" id="taxname"  /></td>
	</tr>		
	<tr>
		<td><label>Tax Rate:</label></td>
		<td><form:input path="taxrate" id="taxrate"  /></td>
	</tr>
	<tr align="center">
		<td><input type="submit" value="ADD"/></td>
		<td><input type="submit" value="INACTIVATE"/></td>
	</tr>
	</table>
	<br/><br/>
	<h3>Existing Taxes: </h3>
	<table cellpadding="5">
		<tr><th>Tax Rate</th><th>Status</th></tr>
	<c:forEach items="${taxList}" var="txList">
		<tr>
			<td>${txList.taxrate}</td>
			<td>${txList.status}</td>
		</tr>
	</c:forEach>
	</table>
</form:form>

</div>
</body>