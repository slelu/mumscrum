<%@ include file="../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="table-responsive">
			<table id="mytable" class="table table-bordred table-striped">
				<tr>
					<th>Release Name</th>
					<th>Description</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
				<tbody>
				<c:forEach var="release" items="${releases}">
					<tr>
						<td>${release.name}</td>
						<td>${release.description}</td>
						<td>${release.startDate}</td>
						<td>${release.endDate}</td>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>