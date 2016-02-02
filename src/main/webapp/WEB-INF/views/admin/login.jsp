<%@ include file="../../layouts/taglib.jsp"%>
<html>
<head>
<%@ include file="../../layouts/library_links.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title><spring:message code="login.form.title" /></title>
<head>
<body>
	<!-- Internationalization Flags -->
	<div class="collapse navbar-collapse " style="margin-right: 100px">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="?language=en"> <img align="right" alt="English"
					src="resources/images/country/united_states_flag.png"
					style="margin-right: -20px" title="English">
			</a></li>
			<li><a href="?language=zh_CN"> <img align="right"
					alt="Chinese" src="resources/images/country/china_flag.png"
					style="margin-right: -20px" title="Chinese">
			</a></li>
			<li><a href="?language=sp"> <img align="right" alt="Spanish"
					src="resources/images/country/spain_flag.png"
					style="margin-right: -20px" title="Español">
			</a></li>
		</ul>
	</div>

	<div id="login-container" class="container">
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-lock"></span>
					<spring:message code="login.form.title" />
				</div>
				<div class="panel-body">
					<c:if test="${not empty param['error']}">
						<div class="alert alert-danger alert-dismissable fade in">
                                <a href="#" class="close" data-dismiss="alert">&times;</a>
                                <strong>Error: </strong>Invalid username or password!
                            </div>
					</c:if>
					<form class="form-horizontal" role="form"
						action="/scrum/j_spring_security_check" method="POST">

						<div class="form-group">
							<label for="username" class="col-sm-3 control-label"> <spring:message
									code="login.form.username" />
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="username"
									name="j_username"
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
									name="j_password"
									placeholder='<spring:message code="login.form.password" />'
									required>
							</div>
						</div>

						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit"
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