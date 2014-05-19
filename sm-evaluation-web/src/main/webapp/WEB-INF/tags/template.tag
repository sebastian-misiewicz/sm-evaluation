<%@tag description="Template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Customers</h1>
	<h4>
		<a href="<c:url value="/addcustomer.html" />">Add</a> | <a
			href="<c:url value="/" />">Search</a>
	</h4>
	<jsp:doBody />
</body>
</html>