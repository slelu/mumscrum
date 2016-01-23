<%@ include file="../../layouts/taglib.jsp"%>
<html>
<head>
<%@ include file="../../layouts/library_links.jsp"%>
<title><spring:message code="login.form.title" /></title>
<head>
<body>
	<div id="custom-bootstrap-menu"
		class="navbar navbar-default navbar-fixed-top " role="navigation">
		<div class="container-fluid ">

			<!-- Logo -->
			<div class="navbar-header">
				<a class="navbar-brand" href="/"> <img
					src="resources/images/agile_scrum.jpg" alt="">
				</a>
			</div>
			<!-- Menu Items -->
			<div class="collapse navbar-collapse navbar-menubuilder"
				style="margin-right: 50px">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="/">Home</a></li>
					<li><a href="/products"><span
							class="glyphicon glyphicon-plus"></span> New Employee</a></li>
					<li><a href="/products"><span
							class="glyphicon glyphicon-menu-hamburger"></span> Employees List</a></li>
					<li><a href="/products"><span
							class="glyphicon glyphicon-plus"></span> New Role</a></li>
					<li><a href="/products"><span
							class="glyphicon glyphicon-menu-hamburger"></span> Roles List</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Welcome Filmon <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span>Settings</a></li>
							<li class="divider"></li>
							<li><a href="#"><span class="glyphicon glyphicon-off"></span>Logout</a></li>
						</ul></li>
					<li><a href="?language=en"> <img align="right"
							alt="English"
							src="resources/images/country/united_states_flag.png"
							style="margin-right: -20px" title="English">
					</a></li>
					<li><a href="?language=zh_CN"> <img align="right"
							alt="Chinese" src="resources/images/country/china_flag.png"
							style="margin-right: -20px" title="Chinese">
					</a></li>
					<li><a href="?language=sp"> <img align="right"
							alt="Spanish" src="resources/images/country/spain_flag.png"
							style="margin-right: -20px" title="Español">
					</a></li>
				</ul>

			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 30px;">
		<div id="loginbox" style="margin-top: 30px;"
			class="mainbox col-md-12 col-md-offset-0 col-sm-8 col-sm-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="panel-title">
						<span class="glyphicon glyphicon-user"></span><b> NEW EMPLOYEE</b>
					</div>
				</div>
				<div class="panel-body">
					<form:form commandName="employee" cssClass="form-horizontal">
						<div class="form-group">

							<label for="firstName" class="col-sm-3 control-label">First
								Name</label>
							<div class="col-sm-4">
								<form:input path="firstname" cssClass="form-control input-sm" />
								<form:errors path="firstname" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">

							<label for="lastName" class="col-sm-3 control-label">Last
								Name</label>
							<div class="col-sm-4">
								<form:input path="lastname" cssClass="form-control input-sm" />
								<form:errors path="lastname" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">

							<label for="username" class="col-sm-3 control-label">Username</label>
							<div class="col-sm-4">
								<form:input path="username" cssClass="form-control input-sm" />
								<form:errors path="username" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-4">
								<form:password path="password" cssClass="form-control input-sm" />
								<form:errors path="password" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="passwordConfirm" class="col-sm-3 control-label">Confirm
								Password</label>
							<div class="col-sm-4">
								<form:password path="passwordConfirm"
									cssClass="form-control input-sm" />
								<form:errors path="passwordConfirm" cssClass="has-error" />
							</div>
						</div>
						<div class="form-group">
							<label for="roles" class="col-sm-3 control-label">Roles</label>
							<div class="col-sm-4">
								<%-- <form:checkboxes element="span class='checkbox'" items="${roles}" path="roles" /> --%>
								 <form:select items="${roles}" itemLabel="roleName" itemValue="roleId" path="rolesIds" multiple="true"/>
								<form:errors path="roles" cssClass="has-error" />
							</div>
						</div>
						<h2></h2>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-3">
								<input type="submit" value="Save"
									class="btn btn-default btn-sm-" /> <input type="submit"
									value="Cancel" class="btn btn-default btn-sm-" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>