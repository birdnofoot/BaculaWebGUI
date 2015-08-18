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
		<h1>Create Pool</h1>
		</div>
		
			<form data-toggle="validator" class="form-horizontal"
				action="createpoolservlet" method="post" novalidate>
				<div class = "form-group">
				<div class="col-md-3">
				<label for="pool_name">Pool name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="pool_name" placeholder="pool name"
					required />
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="pool_type">Pool type <font color="red">*</font> :</label>
				<select class="form-control" name="pool_type" required>
					<option>Backup</option>
					<option>Restore</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="recycle">Recycle <font color="red">*</font> :</label>
				<select  class="form-control" name="recycle" required>
					<option>no</option>
					<option>yes</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="autoprune">Autoprune <font color="red">*</font> :</label>
				<select  class="form-control" name="autoprune" required>
					<option>no</option>
					<option>yes</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="volume_retention">Volume Retention (ex. 365 days) :</label>
				<input type="text" class="form-control" name="volume_retention" placeholder="volume retention"/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="maximum_volume_bytes">Maximum Volume Bytes (ex. 50G) :</label>
				<input type="text" class="form-control" name="maximum_volume_bytes" placeholder="maximum volume bytes"/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="maximum_volumes">Maximum Volumes (ex. 100) :</label>
				<input type="text" class="form-control" name="maximum_volumes" placeholder="maximum volumes"/>
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