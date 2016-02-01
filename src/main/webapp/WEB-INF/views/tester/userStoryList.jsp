<%@ page import="edu.mum.scrum.domain.Employee"%>
<%@ include file="../../layouts/taglib.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		window.setTimeout(function() {
			$(".alert-success").fadeTo(500, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 3000);

	});
</script>
<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:if test="${SUCCESS_MESSAGE != null}">
					<div class="alert alert-success fade in" role="alert">
						<c:out value="${SUCCESS_MESSAGE}" />
					</div>
				</c:if>
				<c:choose>
					<c:when test="${EMPTY_LIST != null}">
						<div class="alert alert-info" role="alert">
							<c:out value="${EMPTY_LIST}" />
							<a href="testerNewWorklog" class="alert-link">Add work logs?</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="table-responsive">
							<table id="mytable" class="table table-bordred table-striped">
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>Status</th>
									<security:authorize access="hasRole('TESTER')">
									<th>Testing Effort</th>
									</security:authorize>
									<th></th>
								</tr>
								<tbody>
									<c:forEach var="userStory" items="${testerUserStoriesToBeEstimated}">
										<tr>
											<td>${userStory.name }</td>
											<td>${userStory.description }</td>
											<td>${userStory.state }</td>
											<security:authorize access="hasRole('TESTER')">
											<td><strong>${userStory.testEstimate eq null ? 'NOT ESTIMATED' : userStory.testEstimate }</strong></td>
											</security:authorize>
											<td><a
												href='<spring:url value="/testerEstimate?userStoryId=${userStory.userStoryId}"/>'>
													<button class="btn btn-primary btn-xs">
														<span class="glyphicon glyphicon-pencil"> Estimate</span>
													</button>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div class="clearfix"></div>
							<ul class="pagination pull-right">
								<li class="disabled"><a href="#"><span
										class="glyphicon glyphicon-chevron-left"></span></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#"><span
										class="glyphicon glyphicon-chevron-right"></span></a></li>
							</ul>

						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>