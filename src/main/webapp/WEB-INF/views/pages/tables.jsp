<<<<<<< HEAD

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<br />
	<br />
	<div align="center">
		<h1>TABLES PAGE</h1>
		<hr />
		<form:form method="POST" modelAttribute="tables">
			<table cellpadding="3">
				<tr>
					<td><label>Floor ID:</label></td>
					<td><select id="comboboxFloor">
							<option value="-1">Select Floor</option>
							<c:forEach var="fr" items="${floorList }">
								<option value="${fr.id }">${fr.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label>Table Name:</label></td>
					<td><form:input path="name" id="name" /></td>
				</tr>
				<tr>
					<td><label>Capacity:</label></td>
					<td><form:input path="capacity" id="capacity" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value="ADD" /></td>
				</tr>
			</table>
		</form:form>
	</div>
=======
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<br/>
<br/>
<div align="center">
	<h1>TABLES PAGE</h1><hr/>
	<form:form method="POST" modelAttribute="tables">
    <form:input type="hidden" path="id" id="id"/>
    <form:input type="hidden" path="tableid" id="tableid"/>
    <table cellpadding="3">
	<%-- <tr>
		<td><label>Establishment Name:</label></td>
	<!-- load the ESTABLISHMENT from the database  -->
    	<td><form:select path="estname" items="${establishmentList}"/></td>
    </tr> --%>
    <tr>
    	<td><label>Floor ID:</label></td>
    	<td><form:select path="floorid" items="${floorList}"/></td>
    </tr>
    <tr>
    	<td><label>Tables Name:</label></td>
    	<td><form:input path="tablename" id="tablename"  /></td>
    </tr>
    <tr>
    	<td><label>Capacity:</label></td>
    	<td><form:input path="capacity" id="capacity"  /></td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="ADD"/></td>
	</tr>
	</table>
	</form:form>
</div>
>>>>>>> 0afafa69fa8937e6671b882cac4af8cac8bff9cd
</body>