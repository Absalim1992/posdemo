<<<<<<< HEAD
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#comboboxMenumaster').on('change', function(){
		
		
		var mmId = $('#comboboxMenumaster option:selected').val();
		alert(mmId);
		$("#uid").val(mmId);
	
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
				<td><form:select id="comboboxMenumaster" path="uid">
						<option value="-1">Select MenuMaster</option>
						<c:forEach var="mm" items="${menumasterList }">
							<option value="${mm.id }">${mm.name }</option>
						</c:forEach>
				</form:select></td>
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

	
	<table id="mmtable" cellpadding="5">
	<caption>Existing Establishments</caption>
		<thead>
			<tr>
				<th>Establishment Name:</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
</div>
</body>