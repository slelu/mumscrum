<%@ page import="edu.mum.scrum.domain.Employee"%>
<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-body">
						<form:form role="form" commandName="testerUserStory" method="POST"
							cssClass="form-horizontal">
							<div class="form-group">
								<label for="name" class="col-sm-3 control-label">Name</label>
								<div class="col-sm-4">
									<form:input class="form-control input-sm" id="name" path="name"
										readonly="true" />
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-3 control-label">Description</label>
								<div class="col-sm-4">
									<form:textarea class="form-control input-sm" id="description"
										rows="10" path="description" readonly="true" />
								</div>
							</div>
							<div class="form-group">
								<label for="priority" class="col-sm-3 control-label">Priority</label>
								<div class="col-sm-4">
									<form:input class="form-control input-sm" id="priority"
										path="priority" readonly="true" />
								</div>
							</div>

							<security:authorize access="hasRole('TESTER')">
								<div class="form-group">
									<label for="estimateTesting" class="col-sm-3 control-label">Testing
										Effort (in HOURS)</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="estimateTesting"
											path="testEstimate" />
										<form:errors path="testEstimate"
											cssClass="has-error alert-danger" />
									</div>
								</div>
							</security:authorize>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-3">
									<button type="submit" class="btn btn-primary">Update</button>
									<a href="testerUserStoryList"><button type="button"
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