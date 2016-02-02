<%@ include file="../../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:if test="${not empty exist}">
<div class="alert alert-danger alert-dismissable fade in">
<a href="#" class="close" data-dismiss="alert">&times;</a>${exist}<br />
</div>
</c:if>		
				 <form:form method="post" action="${pageContext.request.contextPath}/createUserStory" enctype="multipart/form-data" 
				          commandName="userStory" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">UserStory
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="name"
											value="${userStory.name}" />
											<form:errors path="name" cssClass="text-danger" />  
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3">Description:</label>
									<div class="col-sm-4">
										<form:textarea class="form-control input-sm" name="description" path="description" cols="50"
											rows="8" value="${userStory.description}" />
											<form:errors path="description" cssClass="text-danger" /> 
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Priority:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="priority" path="priority"
											value="${userStory.priority}" />
											<form:errors path="priority" cssClass="text-danger" /> 
									</div>
								</div>
								 <input type="hidden" name=userStoryId value="${userStory.userStoryId}"/>
					
								 <input type="hidden" name=state value="new"/>
					
								 
								  <input type="hidden" name=update value="${falsevalue}"/>
			                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
								
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
											<a href="viewUserStory">
						<button type="button"class="btn btn-default">Cancel</button> </a>
									</div>
								</div>

						</form:form>
</html>