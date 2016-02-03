<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-7">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>Sprint Name</th>
					<th>User Story</th>
					<th></th>
				</tr>
				<tbody>
					<c:forEach var="sprint" items="${sprints}">
						<tr>
							<td>${sprint.sprintName}</td>
							<td><ol>
						<c:forEach var="us" items="${sprint.userStories}">
						    <li> ${us.name} </li>
						</c:forEach> </ol> </td>
							<td><a
								href=" <spring:url value="/editSprint?sprintId=${sprint.sprintId}" />">
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


