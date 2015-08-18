<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create a Pool - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<div class = "row">
		
		<div class="page-header">
		<h1>Create Device</h1>
		</div>
		
			<form data-toggle="validator" class="form-horizontal"
				action="createdeviceservlet" method="post" novalidate>
				<div class = "form-group">
				<div class="col-md-3">
				<label for="device_name">Device name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="device_name" placeholder="device name"
					required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="labelmedia">LabelMedia <font color="red">*</font> :</label>
				<select  class="form-control" name="labelmedia">
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="volume_retention">Achieve Device <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="archieve_device"
					placeholder="archieve device" required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="media_type">Media type <font color="red">*</font> :</label>
				<select class="form-control" name="media_type" required>
					<option>File</option>
				</select>
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