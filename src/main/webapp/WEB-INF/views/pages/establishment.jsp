<<<<<<< HEAD
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#comboboxMenumaster').on('change', function(){
		
		
		var mmId = $('#comboboxMenumaster option:selected').val();
		alert(mmId);
		
		$.ajax({
			type: 'GET',
			url: 'loadL1menu/' + mmId,
			success: function(result){
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxL1menu').html(s);
			}
		});
	});
});

</script>

<div align="center">
	<h1>ESTABLISHMENT TABLE</h1>
	<hr />
	<form:form method="POST" modelAttribute="establishment">

		<table cellpadding="3">
			
			<!-- load the MENU MASTER from the database  -->
			<tr>
				<td><label>Select Menu Master: </label></td>
				<td><select id="comboboxMenumaster">
						<option value="-1">Select MenuMaster</option>
						<c:forEach var="mm" items="${menumasterList }">
							<option value="${mm.id }">${mm.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><label>Establishment Name: </label></td>
				<td><form:input path="name" id="name" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="ADD" /></td>
			</tr>
		</table>
	</form:form>

	<%-- <h3>Existing Establishments</h3>
	<table cellpadding="5">
		<tr>
			<th>Menu Master</th>
			<th>Est Name</th>
		</tr>
		<c:forEach items="${establishmentList}" var="estlist">
			<tr>
				<td>${estlist.menumaster}</td>
				<td>${estlist.estname}</td>
			</tr>
		</c:forEach>
	</table> --%>
</div>
=======
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
    <h1>ESTABLISHMENT TABLE</h1><hr/>
    <form:form method="POST" modelAttribute="establishment">
    <form:input type="hidden" path="id" id="id"/>
    
    <table cellpadding="3">
    	<tr>
    		<td><label>Establishment ID: </label> </td>
    		<td><form:input path="estid" id="estid"/></td>
    	</tr>
    	<tr>
    		<td><label>Establishment Name: </label> </td>
    		<td><form:input path="estname" id="estname"  /></td>
    	</tr>
    <!-- load the MENU MASTER from the database  -->
    	<tr>
    		<td><label>Select Menu Master: </label> </td>
    		<td><form:select path="menumaster" items="${menumasterList}"/></td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center"><input type="submit" value="ADD"/></td>
    	</tr>
    </table>
    </form:form>
    
    <h3>Existing Establishments</h3>
    <table cellpadding="5">
    	<tr><th>Menu Master</th><th>Est Name</th></tr>
    	<c:forEach items="${establishmentList}" var="estlist">
    	<tr><td>${estlist.menumaster}</td>
    	<td>${estlist.estname}</td></tr>
		</c:forEach>    
    </table>
</div>	
>>>>>>> 0afafa69fa8937e6671b882cac4af8cac8bff9cd
</body>