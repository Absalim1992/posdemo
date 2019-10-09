<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#comboboxEstablishment').on('change', function(){
		var mmId = $('#comboboxEstablishment option:selected').val();
		$("#eid").val(mmId);
	});
});

function submitCheck(){
	var name=document.getElementById("name").value;
	var combo=document.getElementById("comboboxEstablishment").value;
	console.log(combo);
	if(!combo || combo=="-1"){
		alert("Select Establishment Combobox");
		return false;}
	if(!name || !name.trim()){
		alert("Enter the name");
		return false;
	}
	alert("Floor Added Successfully");
	return true;
}
</script>

<body>
	<div align="center">
		<h1>FLOOR TABLE</h1>
		<hr />
		<form:form method="POST" modelAttribute="floor" onsubmit="submitCheck()">


			<table cellpadding="3">
			
				<tr>
					<!-- load the ESTABLISHMENT from the database  -->
					<td><label>Establishment Name: </label></td>
					<td><form:select id="comboboxEstablishment" path="eid">
						<option value="-1">Select Establishment</option>
						<c:forEach var="est" items="${establishmentList }">
							<option value="${est.id }">${est.name }</option>
						</c:forEach>
				</form:select></td>
				</tr>
				<tr>
					<td><label>Floor Name: </label></td>
					<td><form:input path="name" id="name" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value="ADD" /></td>
				</tr>
			</table>
		</form:form>

		<%-- <h3>Existing Floors</h3>
		<table cellpadding="5">
			<tr>
				<th>Est Name</th>
				<th>Floor Name</th>
			</tr>
			<c:forEach items="${floorList}" var="frlist">
				<tr>
					<td>${frlist.estname }</td>
					<td>${frlist.floorname }</td>
				</tr>
			</c:forEach>
		</table> --%>
	</div>
</body>