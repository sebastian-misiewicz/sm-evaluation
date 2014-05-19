<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<form:form method="POST" modelAttribute="customerTO">
		<div>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
</t:template>