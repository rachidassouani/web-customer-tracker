<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add/Edit Customers</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="col-md-4 col-md-offset-4" style="margin-top: 100px">
				<form:form action="saveCustomer" method="POST" modelAttribute="customer">
					
					<form:hidden path="id"/>
					
					<div class="form-group">
						<label>First Name: </label>
						<form:input path="firstName" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label>Last Name: </label>
						<form:input path="lastName" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label>email: </label>
						<form:input path="email" type="email" class="form-control"/>
					</div>
				
					<input type="submit" value="Save" class="btn btn-success"/>
				</form:form>
				
				<div  style="margin-top: 10px">
					<a href="list" >Back To List</a>
				</div>
			</div>
		</div>
	</body>
</html>