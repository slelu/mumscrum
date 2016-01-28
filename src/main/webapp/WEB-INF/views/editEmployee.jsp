<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
					<form:form commandName="employee" cssClass="form-horizontal">
						<div class="form-group">

							<label for="firstName" class="col-sm-3 control-label" >First
								Name</label>
							<div class="col-sm-4">
								<form:input path="firstname" cssClass="form-control input-sm" value="${employee.firstname}"/>
								<form:errors path="firstname" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">

							<label for="lastName" class="col-sm-3 control-label">Last
								Name</label>
							<div class="col-sm-4">
								<form:input path="lastname" cssClass="form-control input-sm" value="${employee.lastname}"/>
								<form:errors path="lastname" cssClass="has-error" />
							</div>
						</div>
								<div class="form-group">

							<label for="street" class="col-sm-3 control-label">Street
								</label>
							<div class="col-sm-4">
								<form:input path="address.street" cssClass="form-control input-sm" value="${employee.address.street}" />
								<form:errors path="address.street" cssClass="has-error" />
							</div>
						</div>
						
								<div class="form-group">

							<label for="zipcode" class="col-sm-3 control-label">Zipcode
								</label>
							<div class="col-sm-4">
								<form:input path="address.zipcode" cssClass="form-control input-sm" value="${employee.address.zipcode}"/>
								<form:errors path="address.zipcode" cssClass="has-error" />
							</div>
						</div>
						
								<div class="form-group">

							<label for="city" class="col-sm-3 control-label">city
							</label>
							<div class="col-sm-4">
								<form:input path="address.city" cssClass="form-control input-sm" value="${employee.address.city}" />
								<form:errors path="address.city" cssClass="has-error" />
							</div>
						</div>
						
						
						<div class="form-group">

							<label for="state" class="col-sm-3 control-label">state</label>
							<div class="col-sm-4">
								<form:input path="address.state" cssClass="form-control input-sm" value="${employee.address.state}" />
								<form:errors path="address.state" cssClass="has-error" />
							</div>
						</div>
						
								<div class="form-group">

							<label for="country" class="col-sm-3 control-label">country</label>
							<div class="col-sm-4">
								<form:input path="address.country" cssClass="form-control input-sm" value="${employee.address.country}" />
								<form:errors path="address.country" cssClass="has-error" />
							</div>
						</div>
						
						
						
						
						<div class="form-group">

							<label for="username" class="col-sm-3 control-label">Username</label>
							<div class="col-sm-4">
								<form:input path="username" cssClass="form-control input-sm" value="${employee.username}" />
								<form:errors path="username" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-4">
								<form:password path="password" cssClass="form-control input-sm" value="" />
								<form:errors path="password" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="passwordConfirm" class="col-sm-3 control-label">Confirm
								Password</label>
							<div class="col-sm-4">
								<form:password path="passwordConfirm"
									cssClass="form-control input-sm"  value=""/>
								<form:errors path="passwordConfirm" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="roles" class="col-sm-3 control-label" value="">Roles</label>
							<div class="col-sm-4">
								<%-- <form:checkboxes element="span class='checkbox'" items="${roles}" path="roles" /> --%>
								 <form:select items="${roles}" itemLabel="roleName" itemValue="roleId" path="rolesIds" multiple="true" selected="selected" />
								<form:errors path="roles" cssClass="has-error" />
							</div>
						</div>
						<h2></h2>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-3">
							<input type="hidden" name="id" value="employee.employeeId" />
							<input type="hidden" name=enabled value="true"/>
								<input type="submit" value="Update"
									class="btn btn-default btn-sm-" /> <input type="submit"
									value="Cancel" class="btn btn-default btn-sm-" />
							</div>
						</div>
					</form:form>
</html>