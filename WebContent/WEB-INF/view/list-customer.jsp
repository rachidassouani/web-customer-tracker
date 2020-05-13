<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List Customers</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<script src="<c:url value="/resources/javascript/example.js" />"></script>
	</head>
	<body>
		<div class="container" >
			<div style="margin-top: 100px">
				<h3>CRM - Customer Relationship Manager</h3>
			</div>
			<div>
				<a href="showFormAdd" class="btn btn-success"> + Add Customer</a>
			</div>
			<br>
			<table class="table table-striped">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th> 
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers }">
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td>
							<!-- Display the update link -->
							<a href="showFormUpdate?customerId=${customer.id}" 
								class="btn btn-warning">Update
							</a>
							|
							<!-- Display the Delete link -->
							<a  onclick="return confirm('are you sure you want to delete this customer?')" 
								href="delete?customerId=${customer.id}"
								class="btn btn-danger">Delete
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</body>
</html>