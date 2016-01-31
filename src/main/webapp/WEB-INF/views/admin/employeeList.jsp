<%@ include file="../../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number </th>	
					<th> </th>
					<th> </th>
				</tr>
				<tbody>
				<c:forEach var="employee" items="${employees}">
					<tr>
						<td>${employee.firstname}</td>
						<td>${employee.lastname}</td>
						<td>${employee.phoneNumber}</td>
						
						
						<td>
						<a href ='<spring:url value="/editEmployee?id=${employee.employeeId}"/>'>
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
