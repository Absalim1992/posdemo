<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#comboboxEstablishment').on('change', function(){
		
		
		var mmId = $('#comboboxEstablishment option:selected').val();
		alert(mmId);
		$("#fid").val(mmId);
		
		$.ajax({
			type: 'GET',
			url: 'loadFloor/' + mmId,
			success: function(result){
				var result = JSON.parse(result);
				var s = '<option value= -1 > Select Floor </option>';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxFloor').html(s);
			}
		});
	});
});

function submitCheck(){
	var name=document.getElementById("name").value;
	var combo=document.getElementById("comboboxEstablishment").value;
	var combo1=document.getElementById("comboboxFloor").value;
	console.log(combo);
	if(!combo || combo=="-1"){
		alert(" select Establishment Combobox");
		return false;}
	if(!combo1 || combo1=="-1"){
		alert(" select Floor Combobox");
		return false;}
	if(!name || !name.trim()){
		alert("Enter the name");
		return false;
	}
	alert("Tables Added Successfully");
	return true;
}

</script>

<body>
	<div align="center">
		<h1>TABLES PAGE</h1>
		<hr />
		<form:form method="POST" modelAttribute="tables">
			<table cellpadding="3">
				
				<tr>
					<!-- load the ESTABLISHMENT from the database  -->
					<td><label>Establishment Name: </label></td>
					<td><select id="comboboxEstablishment">
						<option value="-1">Select Establishment</option>
						<c:forEach var="est" items="${establishmentList }">
							<option value="${est.id }">${est.name }</option>
						</c:forEach>
				<select></td>
				</tr>
				
				<tr><td><label>L1 Menu:</label></td>
				<td><form:select id="comboboxFloor" path="fid">
				<option value="-1">Select Floor</option>
				</form:select></td></tr>
				
				<%-- <tr>
					<td><label>Floor ID:</label></td>
					<td><form:select id="comboboxFloor" path="">
							<option value="-1">Select Floor</option>
							<c:forEach var="fr" items="${floorList }">
								<option value="${fr.id }">${fr.name }</option>
							</c:forEach>
					</form:select></td>
				</tr> --%>
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
</body>