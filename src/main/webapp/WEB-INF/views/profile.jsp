<%@ include file="../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone</th>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>Street</th>
					<th>Zip Code</th>
					<th>Username</th>
					<th></th>
					
				</tr>
				<tbody>
					<tr>
						<td>${employee.firstname}</td>
						<td>${employee.lastname}</td>
						<td>${employee.phoneNumber}</td>
						<td>${employee.address.country}</td>
						<td>${employee.address.state}</td>
						<td>${employee.address.city}</td>
						<td>${employee.address.street}</td>				
						<td>${employee.address.zipcode}</td>
						<td>${employee.username}</td>
						<td>
						<a href ='<spring:url value="/updateProfile?id=${employee.employeeId}"/>'>
							<button class="btn btn-primary btn-xs">
								<span class="glyphicon glyphicon-pencil"></span>
								EDIT
							</button>
							</a>
					</tr>
					</tbody>
					</table>
					</div>
					</div>
					</div>
					</body>


</html>