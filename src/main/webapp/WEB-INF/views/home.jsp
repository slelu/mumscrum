<%@ include file="../layouts/taglib.jsp"%>
<html>
<head>
<%@ include file="../layouts/library_links.jsp"%>
<title><spring:message code="login.form.title" /></title>
<head>
<body>

	<div id="login-container" class="container">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-lock"></span>
					<spring:message code="login.form.title" />
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form">

						<div class="form-group">
							<label for="username" class="col-sm-3 control-label"> <spring:message
									code="login.form.username" />
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="username"
									placeholder='<spring:message code="login.form.username" />'
									required autofocus>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-sm-3 control-label"> <spring:message
									code="login.form.password" />
							</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="password"
									placeholder='<spring:message code="login.form.password" />'
									required>
							</div>
						</div>

						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="button"
									class="btn btn-primary btn-sm-8 btn-block ">
									<spring:message code="login.form.signin" />
								</button>
							</div>
						</div>
					</form>
				</div>
				<div id="login-footer" class="panel-footer">
					<spring:message code="login.form.footer" />
				</div>
			</div>
		</div>

	</div>

</body>



</html>
