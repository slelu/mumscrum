<%@ include file="../layouts/taglib.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>priority</th>
					<th>state</th>
					<th>Development Estimate</th>
					<th>Test Estimate</th>		
					<th>Sprint</th>
					<th></th>
				</tr>
				<tbody>
		
				<c:forEach var="userStory" items="${userStories}">
				<form:form modelAttribute="userStory" class="form-horizontal" method="POST"
							enctype="utf8">		
					<tr>
						<td>${userStory.name}</td>
						<td>${userStory.description}</td>
						<td>${userStory.priority}</td>
						<td>${userStory.state}</td>
						<td>${userStory.devEstimate}</td>
						<td>${userStory.testEstimate}</td>	
						<td> 
						<form:select name="sprint" path="">
					<form:option value="NONE" label="--- Select ---"/>
						<c:forEach var="sprint" items="${sprints}">
							<option>${sprint.sprintName}<option>
						</c:forEach>
					</form:select> </td>					
						<td>
						<input type="hidden" name=id value="${userStory.userStoryId}"/>	
						<input type="submit" id="btnAdd" class="btn btn-primary"
						value="ADD" />
						<%-- <a href ='<spring:url value="/addToSprint?id=${userStory.userStoryId}"/>'>
							<button class="btn btn-primary btn-xs">
								<span class="glyphicon glyphicon-pencil"></span>
								ADD
							</button>
							</a> --%>
						</td>
					</tr>
					</form:form>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
					