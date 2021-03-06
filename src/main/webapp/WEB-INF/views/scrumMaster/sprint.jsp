<%@ include file="../../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${not empty exist}">
<div class="alert alert-danger alert-dismissable fade in">
<a href="#" class="close" data-dismiss="alert">&times;</a>${exist}<br />
</div>
</c:if>
			
				 <form:form method="post" action="${pageContext.request.contextPath}/createSprint?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" 
				          commandName="sprint" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Sprint
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="sprintName"
											value="${sprint.sprintName}" />
											<form:errors path="sprintName" cssClass="text-danger" />  
									</div>
								</div>
							<div class="form-group">
									<label class="control-label col-sm-3">Start Date:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="datepicker1" path="startDate" 
											 value="${sprint.startDate}" />
											 <form:errors path="startDate" cssClass="text-danger" />  
									</div>
								</div> 
								<div class="form-group">
									<label class="control-label col-sm-3">End Date:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="datepicker2" path="endDate" 
											 value="${sprint.endDate}" />
											 <form:errors path="endDate" cssClass="text-danger" />  
									</div>
								</div> 
								
								 <input type="hidden" name=sprintId value="${sprint.sprintId}"/>	
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
									</div>
								</div>

						</form:form>
</html>