<%@ include file="../layouts/taglib.jsp"%>
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
										<form:textarea class="form-control input-sm" name="description" path="description" cols="50"
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