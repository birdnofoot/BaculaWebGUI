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

			<form class="form-horizontal"
				action="addclientservlet" method="post" novalidate>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_name">Client name :</label>
				<input type="text" class="form-control" name="client_name" placeholder="client name"
					required />
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_ip_address">Client IP Address :</label>
				<input type="text" class="form-control" name="client_ip_address" placeholder="client IP address"
					required />
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="fd_port">File Daemon Port (9102 By default) :</label>
				<input type="text" class="form-control" name="fd_port" placeholder="FD Port"
					required />
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
				<label for="password">Password :</label>
				<input type="text" class="form-control" name="password" placeholder="password"
					required />
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="file_retention">File Retention (ex. 30 days) :</label>
				<input type="text" class="form-control" name="file_retention" placeholder="file retention"
					required />
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