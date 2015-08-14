<!doctype html>
<html lang="en">

<head>
<%@ include file="navbar.jsp" %>
<title>Create a Schedule - Bacula Web GUI</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>

<body>
	<div class="container">
	
		<div class="page-header">
			<h1>Create Schedule</h1>
		</div>

			<form class="form-horizontal"
				action="createscheduleservlet" method="post" novalidate>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="schedule_name">Schedule name :</label>
				<input type="text" class="form-control" name="schedule_name" placeholder="schedule name"
					required />
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="level">Level :</label>
				<select class="form-control" name="level" required>
					<option>Full</option>
					<option>Incremental</option>
					<option>Differential</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="level">Weekday :</label>
				<select class="selectpicker" multiple>
				<option>Monday</option>
				<option>Tuesday</option>
				<option>Wednesday</option>
				<option>Thursday</option>
				<option>Friday</option>
				<option>Saturday</option>
				<option>Sunday</option>
				</select>
				</div>
				</div>
				<br/>
				<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
			</form>
	</div>

</body>
</html>