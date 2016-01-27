<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			
				 <form:form method="post" action="${pageContext.request.contextPath}/addCourse?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" commandName="course" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">UserStory
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="name"
											value="${userStory.name}" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3">Description:</label>
									<div class="col-sm-4">
										<form:textarea class="form-control input-sm" name="description" path="description" cols="50"
											rows="8" value="${userStory.description}" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Priority:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="priority"
											value="${userStory.priority}" />
									</div>
								</div>
								<%-- <input type="hidden" name=id value="${userStory.userStoryId}"/> --%>
								<input type="hidden" name=state value="new"/>
								
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
									</div>
								</div>

						</form:form>
					</div>

</html>