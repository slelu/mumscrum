<%@ include file="../../layouts/taglib.jsp"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">

		<ul class="nav" id="side-menu">
			<security:authorize access="hasRole('HR ADMIN')">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> Human
						Resource Admin<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/createEmployee"><i
								class="fa fa-plus fa-fw"></i> New Employee</a></li>
						<li><a href="${pageContext.request.contextPath}/employeeList"><i
								class="fa fa-list-alt fa-fw"></i> Employees List</a></li>
					</ul> <!-- /.nav-second-level --></li>
			</security:authorize>
			<security:authorize access="hasRole('DEVELOPER')">
				<li><a href="#"><i class="fa fa-square fa-fw"></i>
						Developer<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="developerUserStoryList"><i
								class="fa fa-edit fa-fw"></i> Estimate User Story</a></li>
						<li><a href="developerEstimatedUserStoryList"><i
								class="fa fa-list-alt fa-fw"></i> Add Work Log</a></li>
					</ul> <!-- /.nav-second-level --></li>
			</security:authorize>
			<security:authorize access="hasRole('TESTER')">
				<li><a href="#"><i class="fa fa-check-square fa-fw"></i>
						Tester<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="testerUserStoryList"><i
								class="fa fa-edit fa-fw"></i> Estimate User Story</a></li>
						<li><a href="testerEstimatedUserStoryList"><i
								class="fa fa-list-alt fa-fw"></i> Add Work Log</a></li>
					</ul> <!-- /.nav-second-level --></li>
			</security:authorize>
			<security:authorize access="hasRole('SCRUM MASTER')">
				<li><a href="#"><i class="fa fa-briefcase fa-fw"></i> Scrum
						Master<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">Release <span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a
									href="${pageContext.request.contextPath}/createRelease"><i
										class="fa fa-plus fa-fw"></i> New Release</a></li>
								<li><a
									href="${pageContext.request.contextPath}/viewRelease"><i
										class="fa fa-list-alt fa-fw"></i> Releases List</a></li>
							</ul> <!-- /.nav-third-level --></li>
						<li><a href="#">Sprint <span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a
									href="${pageContext.request.contextPath}/createSprint"><i
										class="fa fa-plus fa-fw"></i> New Sprint</a></li>
								<li><a href="${pageContext.request.contextPath}/viewSprint"><i
										class="fa fa-list-alt fa-fw"></i> Sprints List</a></li>
							</ul> <!-- /.nav-third-level --></li>
						<li><a href="#">User Story <span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a
									href="${pageContext.request.contextPath}/createUserStory"><i
										class="fa fa-plus fa-fw"></i> New User Story</a></li>
								<li><a
									href="${pageContext.request.contextPath}/addToSprint"><i
										class="fa fa-plus fa-fw"></i> Add To Sprint</a></li>
								<li><a
									href="${pageContext.request.contextPath}/viewUserStory"><i
										class="fa fa-list-alt fa-fw"></i> User Stories List</a></li>
							</ul> <!-- /.nav-third-level --></li>
					</ul> <!-- /.nav-second-level --></li>
				<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
						Charts<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="ViewBurnDownChart?sprintID=1">Sprint 1</a></li>
						<li><a href="morris.html">Sprint 2</a></li>
					</ul> <!-- /.nav-second-level --></li>
			</security:authorize>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->