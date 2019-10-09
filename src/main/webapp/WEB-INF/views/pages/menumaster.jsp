<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
function submitCheck(){
	var name=document.getElementById("name").value;
		if(!name || !name.trim()){
		alert("Enter the name");
		return false;
	}
	alert("Menumaster Added Successfully");
	return true;
}
</script>

<div align="center">
    <h1>MENU MASTER</h1><hr/>
    <form:form method="POST" modelAttribute="menumaster" onsubmit="return submitCheck()">
	<table cellpadding="5">
		<tr><td><label>MenuMaster Name:</label></td>
		<td><form:input path="name" id="name"/></td></tr>
		
		<tr><td colspan="2" align="center"><input type="submit" value="ADD"/></td></tr>
	</table>
	</form:form>
	
    <!-- load the MENU MASTER from the database  -->
    <h3>Existing Menu Masters: </h3>
    <table cellpadding="5">
    <c:forEach items="${menumasterList}" var="mmlist">
    <tr><td>${mmlist.name}</td></tr>
    </c:forEach>
    </table>
    
</div>	
