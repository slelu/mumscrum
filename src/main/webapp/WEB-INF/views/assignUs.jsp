<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	<form:form modelAttribute="userStory" class="form-horizontal" method="POST"
							enctype="utf8">
			<div class="form-group">
				<h3 class="boxRate">${userStory.name}</h3>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-3" for="developer">Developer:</label>
				<div class="col-sm-3">
					<form:select name="developer" path="">
					<form:option value="NONE" label="--- Select ---"/>
						<c:forEach var="developer" items="${developers}">
							<option>${developer.firstname}</option>
						</c:forEach>
					</form:select>
				</div>
		</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="tester">tester:</label>
				<div class="col-sm-3">
					<form:select name="tester" path="">
					<form:option value="NONE" label="--- Select ---"/>
						<c:forEach var="tester" items="${testers}">
							<option>${tester.firstname}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="ASSIGN" />
				</div>
			</div>

		</form:form>



</html>