
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
				$('#comboboxMenumaster').on('change',function() {
				var mmId = $('#comboboxMenumaster option:selected').val();
				alert(mmId);

				$.ajax({
						type : 'GET',
						url : 'loadL1menu/'	+ mmId,
						success : function(result) {
								var result = JSON.parse(result);
								var resultTag = '';
								for(var i =0; i < result.length; i++){
									resultTag += "<tr><td>"+result[i].name+"</td></tr>";
								}
								$("#l1table tbody").append(resultTag);
						}
				});
				});
	});
</script>

<body>
	<div align="center">
		<h1>L1 MENU</h1>
		<hr>
		<form:form method="POST" modelAttribute="l1menu">
			<div align="center">
				<table cellpadding="5">
					<tr>
						<td><label>MenuMaster:</label></td>
						<td><select id="comboboxMenumaster">
								<option value="-1">Select MenuMaster</option>
								<c:forEach var="mm" items="${menumasterList }">
									<option value="${mm.id }">${mm.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><label>L1 Name:</label></td>
						<td><form:input path="name" id="name" /></td>
					</tr>

					<tr>
						<td><label>Taxes:</label></td>
						<td><select id="comboboxTaxes">
								<option value="-1">Select a taxes</option>
								<c:forEach var="tax" items="${taxList}">
									<option value="${tax.id }">${tax.taxrate}</option>
								</c:forEach>
						</select></td>
					</tr>
					<br />
					<br />
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="ADD" /></td>
					</tr>
				</table>
			</div>
		</form:form>

		<table id="l1table" width="400" align="center">
			<caption>Existing L1Menu</caption>
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>

</body>