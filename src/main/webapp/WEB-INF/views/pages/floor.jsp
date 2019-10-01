
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div align="center">
		<h1>FLOOR TABLE</h1>
		<hr />
		<form:form method="POST" modelAttribute="floor">


			<table cellpadding="3">
				<tr>
					<!-- load the ESTABLISHMENT from the database  -->
					<td><label>Establishment Name: </label></td>
					<td><select id="comboboxMenumaster">
						<option value="-1">Select MenuMaster</option>
						<c:forEach var="est" items="${establishmentList }">
							<option value="${est.id }">${est.name }</option>
						</c:forEach>
				</select></td>
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