 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
 <body>
 <div align="center">
 <h1>L2 MENU</h1><hr>
 <form:form method="POST" modelAttribute="l2menu">
	<div align="center">
	<table cellpadding="5">
		<tr><td><label>MenuMaster:</label></td>
		<td><select id="comboboxMenumaster">
			<option value="-1">Select MenuMaster</option>
			<c:forEach var="mm" items="${menumasterList }">
				<option value="${mm.id }">${mm.name }</option>
			</c:forEach>
		</select></td></tr>
		<tr><td><label>L1 Menu:</label></td>
		<td><select id="comboboxL1menu">
			<option value="-1">Select L1Menu</option>
		</select></td></tr>
	
		<tr><td><label>L2 Name:</label>
		<form:input path="name" id="name" /></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="ADD" /></td></tr>
	</table>
	</div>
	</form:form>
 
 </div>
 
 </body>