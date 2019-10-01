 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div align="center">
	<h1>FLOOR TABLE</h1><hr/>
	<form:form method="POST" modelAttribute="floor">
    <form:input type="hidden" path="id" id="id"/>
    
    <table cellpadding="3">
	<tr>
	<!-- load the ESTABLISHMENT from the database  -->
		<td><label>Establishment Name: </label> </td>
    	<td><form:select path="estid" items="${establishmentList}"/></td>
    </tr>
    <tr>
    	<td><label>Floor ID: </label> </td>
    	<td><form:input path="floorid" id="floorid"/></td>	
    </tr>
    <tr>
    	<td><label>Floor Name: </label> </td>
    	<td><form:input path="floorname" id="floorname"  /></td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="ADD"/></td>
    </tr>
    </table>
	</form:form>
	
	<h3>Existing Floors</h3>
    <table cellpadding="5">
    	<tr><th>Est Name</th><th>Floor Name</th></tr>
    	<c:forEach items="${floorList}" var="frlist">
    	<tr><td>${frlist.estname }</td>
    	<td>${frlist.floorname }</td></tr>
		</c:forEach>    
    </table>
</div>
</body>