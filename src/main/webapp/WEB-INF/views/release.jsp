<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Release Backlog</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script>
  $(function() {
    $( "#datepicker1" ).datepicker();
    $( "#datepicker2" ).datepicker();
  });
  </script>
</head>

<body>
<body>
	
	<div id="main">
		<section class="container">
		 <form:form modelAttribute="release" class="form-horizontal" method="POST"
			enctype="utf8">
			<fieldset>
				<legend>New Release Backlog</legend>

				
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Release
						Name:</label>
					<div class="col-sm-10">
						<form:input class="form:input-large" id="name"
							path="name" value="" />
					</div>
				</div>
				<div class="form-group">
				<label class="control-label col-sm-2">Description:</label>
				<div class="col-sm-10">
				<sf:textarea name="description" path="description"  cols="50" rows="8" value=""/>
				</div>
			</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="startDate">Start Date :</label>
					<div class="col-sm-10">
						<form:input class="form:input-large" id="datepicker1"
							path="startDate" value="" />
					</div>
					<label class="control-label col-sm-2" for="endDate">End Date :</label>
					<div class="col-sm-10">
						<form:input class="form:input-large" id="datepicker2"
							path="endDate" value="" />
					</div>
				</div>
				<%-- <div class="form-group">
					<label class="control-label col-sm-2" for="endDate">End Date :</label>
					<div class="col-sm-10">
						<form:input class="form:input-large" id="datepicker2"
							path="endDate" value="" />
					</div>
				</div> --%>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="ADD" />
					</div>
				</div>

			</fieldset>
		</form:form> </section>
	</div>
</body>


</html>