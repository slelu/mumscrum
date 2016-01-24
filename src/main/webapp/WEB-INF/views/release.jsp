<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../layouts/library_links.jsp"%>
<title>Release Backlog</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker1").datepicker();
		$("#datepicker2").datepicker();
	});
</script>
</head>

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
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/createRelease"><span
							class="glyphicon glyphicon-plus"></span> New RELEASE</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-align-justify"></span> RELEASES LIST</a></li>
					<!-- <li><a href="#"><span
							class="glyphicon glyphicon-plus"></span> NEW SPRINT</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-align-justify"></span> SPRINTS LIST</a></li> -->
					<li><a href="#"><span
							class="glyphicon glyphicon-plus"></span> NEW USER STORY</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-align-justify"></span> USER STORIES LIST</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Welcome To Mum-Scrum <b class="caret"></b></a>
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
						<span class="glyphicon glyphicon-plus"></span><b> NEW RELEASE BACKLOG</b>
					</div>
				</div>
				<div class="panel-body">
				 <form:form modelAttribute="release" class="form-horizontal" method="POST"
							enctype="utf8">


								<div class="form-group">
									<label class="control-label col-sm-3" for="name">Release
										Name:</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="name" path="name"
											value="" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3">Description:</label>
									<div class="col-sm-4">
										<sf:textarea class="form-control input-sm" name="description" path="description" cols="50"
											rows="8" value="" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="startDate">Start
										Date :</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="datepicker1"
											path="startDate" value="" />
									</div>
									</div>
									<div class="form-group">
									<label class="control-label col-sm-3" for="endDate">End
										Date :</label>
									<div class="col-sm-4">
										<form:input class="form-control input-sm" id="datepicker2"
											path="endDate" value="" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" id="btnAdd" class="btn btn-primary"
											value="ADD" />
									</div>
								</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
</body>


</html>