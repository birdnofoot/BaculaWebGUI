<!doctype html>
<html lang="en">

<head>
<%@ include file="navbar.jsp" %>
<title>Create fileset - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>

<body>
	<div class="container">
		<div class="page-header">
		<h1>Create fileset</h1>
		</div>

		<form data-toggle="validator" id="form_create_fileset" class="form-horizontal"
				action="createfilesetservlet" method="post" novalidate>

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="fileset_name">FileSet name <font color="red">*</font> :</label>
		<input type="text" class="form-control" name="fileset_name" required />
			<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<%
		out.println(PrintJSP.printFieldInfo(Manual.getFilesetBackupPath()));
		%>
		<label for="backup_folder_path">Path to backup <font color="red">*</font> :</label>
		<input type="text" class="form-control" name="backup_folder_path" required />
			<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<%
		out.println(PrintJSP.printFieldInfo(Manual.getFilesetExcludePath()));
		%>
		<label for="exclude_folder_path">Path to exclude :</label>
		<input type="text" class="form-control" name="exclude_folder_path" />
			<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="signature">Choose signature <font color="red">*</font> :</label>
		<select class="form-control" name="signature" required>
			<option>MD5</option>
			<option>SHA1</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="compression">Choose compression type <font color="red">*</font> :</label>
		<select class="form-control" name="compression" required>
			<option>GZIP</option>
			<option>LZO</option>
			<option>No compression</option>
		</select>
		</div>
		</div>
		<br/>
		<br/>
		<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
		</form>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
</body>
</html>