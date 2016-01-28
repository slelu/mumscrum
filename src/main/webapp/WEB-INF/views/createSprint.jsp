<%-- <%-- <%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
				 <form:form modelAttribute="sprint" class="form-horizontal" method="POST"
							enctype="utf8">


								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Sprint
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="sprintName"
											value="" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="startDate">Start
										Date :</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="datepicker1"
											path="startDate" value="" />
									</div>
									</div>
									
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
									</div>
								</div>

						</form:form>
			
</html> --%> 


<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			
				 <form:form method="post" action="${pageContext.request.contextPath}/createUserStory?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" 
				          commandName="sprint" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Sprint
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="sprintName"
											value="${sprint.sprintName}" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3">Start Date:</label>
									<div class="col-sm-4">
										<form:textarea class="form-control input-sm" name="startDate" path="startDate" 
											 value="${sprint.startDate}" />
									</div>
								</div>		
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
									</div>
								</div>

						</form:form>
					

</html>