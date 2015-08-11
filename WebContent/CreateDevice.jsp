<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create a Pool - Bacula Web GUI</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="js/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div class="container">
		<div class = "row">
		
		<div class="page-header">
		<h1>Create Device</h1>
		</div>
		
			<form class="form-horizontal"
				action="createdeviceservlet" method="post" novalidate>
				<div class = "form-group">
				<div class="col-md-3">
				<label for="device_name">Device name :</label>
				<input type="text" class="form-control" name="device_name" placeholder="device name"
					required />
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="media_type">Media type :</label>
				<select class="form-control" name="media_type" required>
					<option>File</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="labelmedia">LabelMedia :</label>
				<select  class="form-control" name="labelmedia" required>
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="volume_retention">Archieve Device :</label>
				<input type="text" class="form-control" name="archieve_device"
					placeholder="archieve device" required />
				</div>
				</div>
				
				<br/>
				<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
				</form>
				</div>
				</div>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>

</body>
</html>