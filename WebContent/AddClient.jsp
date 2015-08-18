<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Add a Client - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>

<body>
	<div class="container">
	
		<div class="page-header">
			<h1>Add Client</h1>
		</div>

			<form data-toggle="validator" class="form-horizontal"
				action="addclientservlet" method="post" novalidate>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_name">Client name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="client_name" placeholder="client name"
					required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_ip_address">Client IP Address <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="client_ip_address" placeholder="client IP address"
					required />
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
								
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="catalog">Catalog :</label>
				<select class="form-control" name="catalog" required>
					<option>MyCatalog</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="file_retention">File Retention (ex. 30 days) :</label>
				<input type="text" class="form-control" name="file_retention" placeholder="file retention"
					/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="autoprune">Autoprune :</label>
				<select  class="form-control" name="autoprune" required>
					<option>no</option>
					<option>yes</option>
				</select>
				</div>
				</div>

				<br/>
				<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
			</form>
	</div>
</body>
</html>