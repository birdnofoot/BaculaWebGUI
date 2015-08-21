<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create job - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>
<body>
	<div class="container">
	<div class="page-header">
		<h1>Create job</h1>
	</div>
	
	<form data-toggle="validator" class="form-horizontal"
			action="createjobservlet" method="post" novalidate>
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_name">Job name <font color="red">*</font> :</label>
	<input type="text" class="form-control" name="job_name" placeholder="job name"
		required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_type">Job type <font color="red">*</font> :</label>
	<select class="form-control" name="job_type" required>
		<option>Backup</option>
		<option>Restore</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="jobdefs">JobDefs <font color="red">*</font> :</label>
	<select class="form-control" name="jobdefs" required>
		<% out.println(PrintJSP.printSelectOptionByType("JobDefs")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="client">Client <font color="red">*</font> :</label>
	<select class="form-control" name="client" required>
		<% out.println(PrintJSP.printSelectOptionByType("Client")); %>
	</select>
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="pool">Pool <font color="red">*</font> :</label>
	<select class="form-control" name="pool" required>
		<% out.println(PrintJSP.printSelectOptionByType("Pool")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="storage">Storage <font color="red">*</font> :</label>
	<select class="form-control" name="storage" required>
		<% out.println(PrintJSP.printSelectOptionByType("Storage")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="fileset">FileSet <font color="red">*</font> :</label>
	<select class="form-control" name="fileset" required>
		<% out.println(PrintJSP.printSelectOptionByType("FileSet")); %>
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
	out.println(PrintJSP.printFieldInfo(Manual.getJobScheduleInfo()));
	%>
	<label for="schedule">Schedule :</label>
	<select class="form-control" name="schedule">
		<option>None</option>
		<% out.println(PrintJSP.printSelectOptionByType("Schedule")); %>
	</select>
	</div>
	</div>
	
	</div>
	
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