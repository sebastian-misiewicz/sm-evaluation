<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:template>
	<form method="get">
		<input type="text" name="name" value="${name}">
		<button type="submit">Search</button>
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>action</th>
		</tr>
		<c:forEach var="customerTO" items="${customerTOs}">
			<tr>
				<td>${customerTO.id}</td>
				<td>${customerTO.name}</td>
				<td><a href="<c:url value="/editcustomer.html?id=${customerTO.id}"/>">edit</a>|<a
					href="<c:url value="/deletecustomer.html?id=${customerTO.id}"/>">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</t:template>