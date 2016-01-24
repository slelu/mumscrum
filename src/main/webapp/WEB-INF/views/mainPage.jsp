<%@ include file="../layouts/taglib.jsp"%>
<html>
<head>
<%@ include file="../layouts/library_links.jsp"%>
<title>Home</title>
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
					<li><a
						href="${pageContext.request.contextPath}/createEmployee"><span
							class="glyphicon glyphicon-plus"></span> New Employee</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-menu-hamburger"></span> Employees List</a></li>
					<li><a href="${pageContext.request.contextPath}/createRelease"><span
							class="glyphicon glyphicon-plus"></span> New RELEASE</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-align-justify"></span> RELEASES LIST</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Welcome to Mum Scrum <b class="caret"></b></a>
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
		<div class="panel-heading">
			<div class="panel-title">
				<span class="glyphicon glyphicon-plus"></span><b> <c:if
						test="${not empty success}">
						<div class="alert alert-success">${success}<br />
						</div>
					</c:if>
				</b>
			</div>
		</div>
	</div>				
</body>
</html>