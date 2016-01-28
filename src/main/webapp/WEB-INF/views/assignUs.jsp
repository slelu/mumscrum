<%@ include file="../layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			
		
<div class="form-group">
			<label class="control-label col-sm-2">Developer:</label>
				<div class="col-sm-10">
				<form:select name="developer" path="assignedDev">
					<c:forEach var="developer" items="${developers}">
	    				<option>${developer}</option>
					</c:forEach>
				</form:select>
				</div>
				<label class="control-label col-sm-2">tester:</label>
				<div class="col-sm-10">
				<form:select name="tester" path="assignedTes">
					<c:forEach var="tester" items="${testers}">
	    				<option>${tester}</option>
					</c:forEach>
				</form:select>
				</div>
			</div>
	
</html>