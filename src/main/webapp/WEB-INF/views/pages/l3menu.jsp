<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$('#comboboxMenumaster').on('change', function(){
		//$('#comboboxL2menu option').remove();
		
		var mmId = $('#comboboxMenumaster option:selected').val();
		alert(mmId);
		
		$.ajax({
			type: 'GET',
			url: 'loadL1menu/' + mmId,
			success: function(result){
				var result = JSON.parse(result);
				var s = '<option value= -1 > Select L1Menu </option>';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxL1menu').html(s);
			}
		});
	});
	
	$('#comboboxL1menu').on('change', function(){
		var l1Id = $('#comboboxL1menu option:selected').val();
		alert(l1Id);
		$("#lid").val(l1Id);
		
		$.ajax({
			type: 'GET',
			url: 'loadL2menu/' + l1Id,
			success: function(result){
				var result = JSON.parse(result);
				var s = '<option value= -1 > Select L2Menu </option>';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxL2menu').html(s);
			}
		});
	});
	
	$('#comboboxTaxes').on('change', function(){
		var mmId = $('#comboboxTaxes option:selected').val();
		$("#tid").val(mmId);
	});
});

</script>

<body>
	<div align="center">
		<h1>L3 MENU</h1>
		<hr>

		<form:form method="POST" modelAttribute="l3menu">
			<div align="center">
			<table cellpadding="5">
				<tr><td><label>MenuMaster:</label></td>
				<td> <select id="comboboxMenumaster">
					<option value="-1">Select MenuMaster</option>
					<c:forEach var="mm" items="${menumasterList }">
						<option value="${mm.id }">${mm.name }</option>
					</c:forEach>
				</select></td></tr>
				<tr><td><label>L1 Menu:</label></td>
				<td> <select id="comboboxL1menu">
					<option value="-1">Select L1Menu</option>
				</select></td></tr>
				<tr><td><label>L2 Menu:</label></td>
				<td> <form:select id="comboboxL2menu" path="lid">
					<option value="-1">Select L2Menu</option>
				</form:select></td></tr>
				<tr><td><label>L3 Name:</label></td>
				<td><form:input path="name" id="name" /></td></tr>
				
				<tr><td><label>Taxes:</label></td>
		<td><form:select id="comboboxTaxes" path="tid">
			<option value="-1">Select a taxes</option>
			<c:forEach var="tax" items="${taxList}">
				<option value="${tax.id }">${tax.taxrate}</option>
			</c:forEach>
		</form:select></td></tr><br/><br/>
				
				<tr><td colspan="2" align="center"><input type="submit" value="ADD" /></td></tr>
			</table>
			</div>
		</form:form>
	</div>

</body>