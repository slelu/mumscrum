<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
				 <form:form action="../editSprint/${sprint.sprintId}" class="form-horizontal" method="POST"
							enctype="utf8">


								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Sprint
										Name:</label>
									<div class="col-sm-4">
										<input class="form-control input-sm" id="name" name="sprintName"
											value="${sprint.sprintName}" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="startDate">Start
										Date :</label>
									<div class="col-sm-4">
										<input class="form-control input-sm" id="datepicker1"
											name="startDate" value="${sprint.startDate}" />
									</div>
									</div>
				
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
									   <%--  <input type="hidden" name="id" value="${sprint.sprintId}" /> --%>
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="Edit" />
									</div>
								</div>

						</form:form>
</html>