<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<body>
	<table  width="1000">
		<form:form modelAttribute="release" class="form-horizontal"
			method="POST">
			<tr>
				<td>
					<div class="form-group">
						<label class="control-label col-sm-3" for="name">Release
							Name:</label>
						<div class="col-sm-4">
							<form:input class="form-control input-sm" id="name" path="name"
								value="" />
								<form:errors path="name" cssClass="text-danger" />  
						</div>
					</div>
				</td>
				<td>
					<div class="form-group">
						<label class="control-label col-sm-3" for="startDate">Start Date :</label>
						<div class="col-sm-4">
							<form:input class="form-control input-sm" id="datepicker1"
								path="startDate" value="" />
								
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label class="control-label col-sm-3">Description:</label>
						<div class="col-sm-4">
							<form:textarea class="form-control input-sm" name="description"
								path="description" cols="60" rows="6" value="" />
								<form:errors path="description" cssClass="text-danger" />  
						</div>
					</div>
				</td>

				<td>
					<div class="form-group">
						<label class="control-label col-sm-3" for="endDate">End Date :</label>
						<div class="col-sm-4">
							<form:input class="form-control input-sm" id="datepicker2"
								path="endDate" value="" />
						</div>
					</div>
				</td>
			</tr>
			<tr>
			<th></th>
				<th>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="ADD" />
						</div>
					</div>
				</th>
			</tr>
		</form:form>
	</table>
</body>

</html>