<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>priority</th>
					<th>state</th>
					<th>Developer</th>
					<th>Tester</th>
					<th>Development Estimate</th>
					<th>Test Estimate</th>
					<th>Sprint Name</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tbody>
				<c:forEach var="userStory" items="${userStories}">
					<tr>
						<td>${userStory.name}</td>
						<td>${userStory.description}</td>
						<td>${userStory.priority}</td>
						<td>${userStory.state}</td>
						<td>${userStory.assignedDev.firstname}</td>
						<td>${userStory.assignedTes.firstname}</td>
						<td>${userStory.devEstimate}</td>
						<td>${userStory.testEstimate}</td>
						<td>${userStory.sprint.sprintName}</td>
						<td>
						<a href ='<spring:url value="/editUserStory?id=${userStory.userStoryId}"/>'>
							<button class="btn btn-primary btn-xs">
								<span class="glyphicon glyphicon-pencil"></span>
								EDIT
							</button>
							</a>
						</td>
						<td>
						<a href ='<spring:url value="/assignUserStory?id=${userStory.userStoryId}"/>'>
							<button class="btn btn-primary btn-xs">
								<span class="glyphicon glyphicon-pencil"></span>
								ASSIGN
							</button>
							</a>
						</td>
						<td>
						<a href ='<spring:url value="/deleteUserStory?id=${userStory.userStoryId}"/>'>
							<button type="button" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-remove"></span>DELETE
							</button>
							</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
					</body>


</html>