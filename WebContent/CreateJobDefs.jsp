<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create jobdef - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>
<body>
	<div class="container">
	<div class="page-header">
		<h1>Create jobdef</h1>
	</div>
	
	<form data-toggle="validator" class="form-horizontal"
			action="createjobdefservlet" method="post" novalidate>
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="jobdef_name">JobDef name <font color="red">*</font> :</label>
	<input type="text" class="form-control" name="jobdef_name" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="jobdef_type">JobDef type <font color="red">*</font> :</label>
	<select class="form-control" name="jobdef_type" required>
		<option>Backup</option>
		<option>Restore</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="level">Level <font color="red">*</font> :</label>
	<select class="form-control" name="level" required>
		<option>Full</option>
		<option>Incremental</option>
		<option>Differential</option>
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
	<label for="fileset">FileSet <font color="red">*</font> :</label>
	<select class="form-control" name="fileset" required>
		<% out.println(PrintJSP.printSelectOptionByType("FileSet")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="schedule">Schedule <font color="red">*</font> :</label>
	<select class="form-control" name="schedule" required>
		<% out.println(PrintJSP.printSelectOptionByType("Schedule")); %>
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
	<label for="pool">Pool <font color="red">*</font> :</label>
	<select class="form-control" name="pool" required>
		<% out.println(PrintJSP.printSelectOptionByType("Pool")); %>
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
	out.println(PrintJSP.printFieldInfo(Manual.getJobDefPriorityInfo()));
	%>
	<label for="priority">Priority :</label>
	<input type="text" class="form-control" name="priority" placeholder="Default value : 10"/>
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