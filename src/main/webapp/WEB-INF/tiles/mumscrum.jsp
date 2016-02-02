<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link
	href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="resources/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-brand" href="/"> <img
					src="resources/images/agile_scrum.png" alt="">
				</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="fa fa-flag-checkered fa-fw"></i> <i
						class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="?language=en"> <img alt="English"
								src="resources/images/country/united_states_flag.png"
								title="English"> US-English
						</a></li>
						<li><a href="?language=zh_CN"> <img alt="Chinese"
								src="resources/images/country/china_flag.png" title="Chinese">
								Chinese
						</a></li>
						<li><a href="?language=sp"> <img alt="Spanish"
								src="resources/images/country/spain_flag.png" title="Español">
								Español
						</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->
			<br /> <br />

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">

					<ul class="nav" id="side-menu">

						<li><a href="#"><i class="fa fa-user fa-fw"></i> Human
								Resource Admin<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html"><i class="fa fa-plus fa-fw"></i>
										New Employee</a></li>
								<li><a href="morris.html"><i
										class="fa fa-list-alt fa-fw"></i> Employees List</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-square fa-fw"></i>
								Developer<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html"><i class="fa fa-edit fa-fw"></i>
										Estimate User Story</a></li>
								<li><a href="morris.html"><i
										class="fa fa-list-alt fa-fw"></i> Add Work Log</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-check-square fa-fw"></i>
								Tester<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html"><i class="fa fa-edit fa-fw"></i>
										Estimate User Story</a></li>
								<li><a href="morris.html"><i
										class="fa fa-list-alt fa-fw"></i> Add Work Log</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-briefcase fa-fw"></i>
								Scrum Master<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="#">Release <span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#"><i class="fa fa-plus fa-fw"></i> New
												Release</a></li>
										<li><a href="#"><i class="fa fa-list-alt fa-fw"></i>
												Releases List</a></li>
									</ul> <!-- /.nav-third-level --></li>
								<li><a href="#">Sprint <span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#"><i class="fa fa-plus fa-fw"></i> New
												Sprint</a></li>
										<li><a href="#"><i class="fa fa-list-alt fa-fw"></i>
												Sprints List</a></li>
									</ul> <!-- /.nav-third-level --></li>
								<li><a href="#">User Story <span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#"><i class="fa fa-plus fa-fw"></i> New
												User Story</a></li>
										<li><a href="#"><i class="fa fa-list-alt fa-fw"></i>
												User Stories List</a></li>
									</ul> <!-- /.nav-third-level --></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
								Charts<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html">Sprint 1</a></li>
								<li><a href="morris.html">Sprint 2</a></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Blank</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
