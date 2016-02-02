<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-5">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>Sprint Name</th>
					<th></th>
				</tr>
				<tbody>
					<c:forEach var="sprint" items="${sprints}">
						<tr>
							<td>${sprint.sprintName}</td>
							<td><a
								href=" <spring:url value="/editSprint?id=${sprint.sprintId}" />">
									<button class="btn btn-primary btn-xs">
										<span class="glyphicon glyphicon-pencil"></span> Edit
									</button>
							</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>


