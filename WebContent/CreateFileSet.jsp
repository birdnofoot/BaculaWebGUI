<!doctype html>
<html lang="en">

<head>
<%@ include file="navbar.jsp" %>
<title>Create FileSet - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div class = "row">
		<div class="page-header">
		<h1>Create FileSet</h1>
		</div>

		<form id="form_create_fileset" class="form-horizontal"
				action="createfilesetservlet" method="post" novalidate>

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="fileset_name">FileSet name :</label>
		<input type="text" class="form-control" name="fileset_name" placeholder="fileset name"
			required />
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="backup_folder_path">Backup folder path :</label>
		<input type="text" class="form-control" name="backup_folder_path" placeholder="Backup folder path"
			required />
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="exclude_folder_path">Exclude folder path :</label>
		<input type="text" class="form-control" name="exclude_folder_path" placeholder="Exclude folder path"
			required />
		</div>
		</div>

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="signature">Choose signature :</label>
		<select class="form-control" name="signature" required>
			<option>MD5</option>
			<option>SHA1</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="compression">Choose compression type :</label>
		<select class="form-control" name="compression" required>
			<option>no compression</option>
			<option>GZIP</option>
			<option>LZO</option>
		</select>
		</div>
		</div>
		<br/>
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