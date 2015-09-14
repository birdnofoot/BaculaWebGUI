<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create Client - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>

<body>
	<div class="container">
	
		<div class="page-header">
			<h1>Create Client</h1>
		</div>

			<form data-toggle="validator" class="form-horizontal"
				action="createservlet" method="post" novalidate>
				
				<input type="hidden" name="create_type" value="client">
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_name">Client name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="client_name" required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="client_ip_address">Client IP Address <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="client_ip_address" required />
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
								
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="catalog">Catalog <font color="red">*</font> :</label>
				<select class="form-control" name="catalog" required>
					<option>MyCatalog</option>
				</select>
				</div>
				</div>
				<br/>
				<button type="button" class="btn btn-default" onclick="toggleContent()">Show advanced options</button>
				<div ID="advanced_form" style="display:none;">
				<br/>
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getClientFileRetentionInfo()));
				%>
				<label for="file_retention">File Retention :</label>
				<input type="text" class="form-control" name="file_retention"/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="autoprune">Autoprune :</label>
				<select class="form-control" name="autoprune" required>
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				</div>
				<br/>
				<br/>
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