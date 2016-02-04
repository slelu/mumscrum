<%@ include file="../../layouts/taglib.jsp"%>
<div class="row">
	<div class="col-md-8">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
                          <h3 class="boxRate">${userStory.name}</h3>
						<form:form modelAttribute="userStory" class="form-horizontal"
							method="POST" enctype="utf8">
			
							<div class="form-group">
								<label class="control-label col-lg-3" for="developer">Developer:</label>
								<div class="col-sm-3">
									<form:select name="developer" path="">
										<form:option value="NONE" label="--- Select ---" />
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
										<form:option value="NONE" label="--- Select ---" />
										<c:forEach var="tester" items="${testers}">
											<option>${tester.firstname}</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<input type="submit" id="btnAdd" class="btn btn-primary"
										value="ASSIGN" /> <a href="viewUserStory">
										<button type="button" class="btn btn-default">Cancel</button>
									</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


</html>