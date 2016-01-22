<%@ include file="../layouts/taglib.jsp"%>
<html>
<head>
<%@ include file="../layouts/library_links.jsp"%>
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