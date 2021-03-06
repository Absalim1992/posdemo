 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#comboboxMenumaster').on('change', function(){
	var mmId = $('#comboboxMenumaster option:selected').val();
		//alert(mmId);
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
	
	$('#comboboxL1menu').on('change',function() {
		var mmId = $('#comboboxL1menu option:selected').val();
		//alert(mmId);
		$("#uid").val(mmId);

		$.ajax({
				type : 'GET',
				url : 'loadL2menu/'	+ mmId,
				success : function(result) {
						var result = JSON.parse(result);
						var resultTag = '';
						for(var i =0; i < result.length; i++){
							resultTag += "<tr><td>"+result[i].name+"</td></tr>";
						}
						$("#l2table tbody").append(resultTag);
				}
		});
		});
});

function submitCheck(){
	var name=document.getElementById("name").value;
	var combo=document.getElementById("comboboxMenumaster").value;
	var combo1=document.getElementById("comboboxL1menu").value;
	console.log(combo);
	if(!combo || combo=="-1"){
		alert(" select Menumaster Combobox");
		return false;}
	if(!combo1 || combo1=="-1"){
		alert(" select L1Menu Combobox");
		return false;}
	if(!name || !name.trim()){
		alert("Enter the name");
		return false;
	}
	alert("L1Menu Added Successfully");
	return true;
}

</script>
 <body>
 <div align="center">
 <h1>L2 MENU</h1><hr>
 <form:form method="POST" modelAttribute="l2menu" onsubmit="return submitCheck()">
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
		<td><form:select id="comboboxL1menu" path="lid">
			<option value="-1">Select L1Menu</option>
		</form:select></td></tr>
	
		<tr><td><label>L2 Name:</label></td>
		<td><form:input path="name" id="name" /></td></tr>
		
		<%-- <tr><td><label>Taxes:</label></td>
		<td><select id="comboboxTaxes">
			<option value="-1">Select a taxes</option>
			<c:forEach var="tax" items="${taxList}">
				<option value="${tax.id }">${tax.taxrate}</option>
			</c:forEach>
		</select></td></tr><br/><br/> --%>
		<tr><td colspan="2" align="center"><input type="submit" value="ADD" /></td></tr>
	</table>
	</div>
	</form:form>
	<br/><br/>
	<table cellpadding="5" id="l2table" width="400" align="center">
			<h3><caption>Existing L2Menu</caption></h3>
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