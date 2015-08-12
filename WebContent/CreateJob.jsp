<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<title>Create Job - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="page-header">
		<h1>Create Job</h1>
	</div>
	
	<form class="form-horizontal"
			action="createjobservlet" method="post" novalidate>
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_name">Job name :</label>
	<input type="text" class="form-control" name="job_name" placeholder="job name"
		required />
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_type">Job type :</label>
	<select class="form-control" name="job_type" required>
		<option>Backup</option>
		<option>Restore</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="client">Client :</label>
	<select class="form-control" name="client" required>
	<%
	   	ServletContext servletContext = request.getServletContext();
		DatabaseController db_controller = (DatabaseController)servletContext.getAttribute("db_controller");
		db_controller.openConnection();
		ResultSet client = db_controller.getClients();

		while(client.next()){
			out.println("<option>"+client.getString("Name")+"</option>");
		}
	%>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="storage">Storage :</label>
	<select class="form-control" name="storage" required>
		<option>Default</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="pool">Pool :</label>
	<select class="form-control" name="pool" required>
	<%
		ResultSet storage = db_controller.getStorages();
		while(storage.next()){
			out.println("<option>"+storage.getString("Name")+"</option>");
		}
	%>
	</select>
	</div>
	</div>
	
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="message_type">Message type :</label>
	<select class="form-control" name="message_type" required>
		<option>Standard</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="location">Location (optional) :</label>
	<input type="text" class="form-control" name="location" placeholder="location"/>
	</div>
	</div>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<% db_controller.closeConnection(); %>
	</form>
	</div>
</body>
</html>