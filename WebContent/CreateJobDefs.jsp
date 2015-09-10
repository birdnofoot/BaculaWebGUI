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
			action="createjobdefsservlet" method="post" novalidate>
			
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="jobdef_name">JobDef name <font color="red">*</font> :</label>
	<input type="text" class="form-control" name="jobdef_name" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="jobdef_type">JobDef type :</label>
	<select class="form-control" name="jobdef_type">
		<option></option>
		<option>Backup</option>
		<option>Restore</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="level">Level :</label>
	<select class="form-control" name="level">
		<option></option>
		<option>Full</option>
		<option>Incremental</option>
		<option>Differential</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="client">Client :</label>
	<select class="form-control" name="client">
		<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("Client")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="fileset">FileSet :</label>
	<select class="form-control" name="fileset">
	<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("FileSet")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="schedule">Schedule :</label>
	<select class="form-control" name="schedule">
	<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("Schedule")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="storage">Storage :</label>
	<select class="form-control" name="storage">
	<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("Storage")); %>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="pool">Pool :</label>
	<select class="form-control" name="pool">
	<option></option>
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
	
		<div class = "form-group">
	<div class="col-xs-3">
	<label for="full_backup_pool">Full Backup Pool :</label>
	<select class="form-control" name="full_backup_pool">
	<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("Pool")); %>
		</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="incremental_backup_pool">Incremental Backup Pool :</label>
	<select class="form-control" name="incremental_backup_pool">
	<option></option>
		<% out.println(PrintJSP.printSelectOptionByType("Pool")); %>
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