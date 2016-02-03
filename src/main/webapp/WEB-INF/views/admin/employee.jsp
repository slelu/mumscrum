<%@ include file="../../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${not empty message}">
<div class="alert alert-danger alert-dismissable fade in">
<a href="#" class="close" data-dismiss="alert">&times;</a>${message}<br />
</div>
</c:if>
					<form:form method="post" action="${pageContext.request.contextPath}/createEmployee" enctype="multipart/form-data"
					 commandName="employee" class="form-horizontal" role="form">
					 
						<div class="form-group">
							<label class="control-label col-sm-3" for="name">First
								Name</label>
							<div class="col-sm-4">
								<form:input path="firstname" cssClass="form-control input-sm" value="${employee.firstname}" />
								<form:errors path="firstname" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">

							<label class="control-label col-sm-3" for="name">Last
								Name</label>
							<div class="col-sm-4">
								<form:input path="lastname" cssClass="form-control input-sm" value="${employee.lastname}"/>
								<form:errors path="lastname" cssClass="text-danger" />
							</div>
						</div>
						
						<div class="form-group">

							<label class="control-label col-sm-3" for="name">Phone Number</label>
							<div class="col-sm-4">
								<form:input path="phoneNumber" cssClass="form-control input-sm" value="${employee.phoneNumber}" />
								<form:errors path="phoneNumber" cssClass="has-error" />
							</div>
						</div>
						
						
								<div class="form-group">

							<label class="control-label col-sm-3" for="name">Street
								</label>
							<div class="col-sm-4">
								<form:input path="address.street" cssClass="form-control input-sm" value="${employee.address.street}" />
								<form:errors path="address.street" cssClass="text-danger" />
							</div>
						</div>
						
								<div class="form-group">

							<label class="control-label col-sm-3" for="name">Zipcode
								</label>
							<div class="col-sm-4">
								<form:input path="address.zipcode" cssClass="form-control input-sm" value="${employee.address.zipcode}"/>
								<form:errors path="address.zipcode" cssClass="text-danger" />
							</div>
						</div>
						
								<div class="form-group">

							<label class="control-label col-sm-3" for="name">city
							</label>
							<div class="col-sm-4">
								<form:input path="address.city" cssClass="form-control input-sm" value="${employee.address.city}" />
								<form:errors path="address.city" cssClass="text-danger" />
							</div>
						</div>
						
						
						<div class="form-group">

							<label class="control-label col-sm-3" for="name">state</label>
							<div class="col-sm-4">
								<form:input path="address.state" cssClass="form-control input-sm" value="${employee.address.state}" />
								<form:errors path="address.state" cssClass="text-danger" />
							</div>
						</div>
						
								<div class="form-group">

							<label class="control-label col-sm-3" for="name">country</label>
							<div class="col-sm-4">
								<form:input path="address.country" cssClass="form-control input-sm" value="${employee.address.country}" />
								<form:errors path="address.country" cssClass="text-danger" />
							</div>
						</div>
						
						
						
						
						<div class="form-group">

							<label class="control-label col-sm-3" for="name">Username</label>
							<div class="col-sm-4">
								<form:input path="username" cssClass="form-control input-sm" value="${employee.username}" />
								<form:errors path="username" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="name">Password</label>
							<div class="col-sm-4">
								<form:password path="password" cssClass="form-control input-sm" />
								<form:errors path="password" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="name">Confirm
								Password</label>
							<div class="col-sm-4">
								<form:password path="passwordConfirm"
									cssClass="form-control input-sm" />
								<form:errors path="passwordConfirm" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label for="roles" class="col-sm-3 control-label">Roles</label>
							<div class="col-sm-4">
								<%-- <form:checkboxes element="span class='checkbox'" items="${roles}" path="roles" /> --%>
								 <form:select items="${roles}" itemLabel="roleName" itemValue="roleId" path="rolesIds" multiple="true" selected="selected"/>
								<form:errors path="roles" cssClass="text-danger" />
							</div>
						</div>
						<h2></h2>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-3">
							<input type="hidden" name=enabled value="true"/>
								<input type="hidden" name="employeeId" value="${employee.employeeId}" />
								<input type="submit" value="Save"
									class="btn btn-default btn-sm-" /><a href="employeeList"> 
									<button type="button"class="btn btn-default">Cancel</button> </a>
							</div>
						</div>
					</form:form>

</html>