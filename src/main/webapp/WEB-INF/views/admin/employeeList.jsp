<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number </th>	
					<th>Employee Role </th>
					<th>Enabled</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tbody>
				<c:forEach var="employee" items="${employees}">
					<tr>
						<td>${employee.firstname}</td>
						<td>${employee.lastname}</td>
						<td>${employee.phoneNumber}</td>
						<td><ul>
						<c:forEach var="role" items="${employee.roles}">
						    <li>${role.roleName}</li>
						</c:forEach> </ul> </td>
					
						<td>${employee.enabled}</td>
						<td>
						<a href ='<spring:url value="/editEmployee?employeeId=${employee.employeeId}"/>'>
							<button class="btn btn-primary btn-xs">
								<span class="glyphicon glyphicon-pencil"></span>
								EDIT
							</button>
							</a>
						</td>
						
						
						<td>
						<a href ='<spring:url value="/deleteEmployee/${employee.employeeId}"/>'>
							<button type="button" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-remove"></span>DELETE
							</button>
							</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
