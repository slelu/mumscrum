<%@ page import="edu.mum.scrum.domain.Employee"%>
<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-body">
						<form:form role="form" commandName="developerNewWorklog" method="POST"
							cssClass="form-horizontal">
							
							<security:authorize access="hasRole('DEVELOPER')">
								<div class="form-group">
									<label for="estimateDevelopment" class="col-sm-3 control-label">Work Done (in HOURS)</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm"
											id="estimateDevelopment" path="workHours" />
										<form:errors path="workHours"
											cssClass="has-error alert-danger" />
									</div>
								</div>
							</security:authorize>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-3">
									<button type="submit" class="btn btn-primary">Add</button>
									<a href="developerEstimatedUserStoryList"><button type="button"
											class="btn btn-default">Cancel</button></a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.col-lg-12 -->
</div>