<!doctype html>
<html lang="en">

<head>
	<title>Create FileSet</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<script src = "script/jquery-2.1.1.min.js"></script>
	<script>
		$(function(){
			$("#header").load("header.jsp");
		});
	</script>
</head>

<body>
	<div id="header"></div>
	<div id="main">
	<div id="container">
	<h1>Create FileSet</h1>
	</div>

	<div class="form_create_fileset">
	<form id="form_create_fileset" class="form" action="createfilesetservlet.do" method="post" novalidate>
	<br/>
	<p>FileSet name : </p>
				<input type="text" name="fileset_name" placeholder="fileset name" required/><br/><br/>
				<p>Backup folder path : </p>
				<input type="text" name="backup_folder_path" placeholder="Backup folder path" required/><br/><br/>
				<p>Exclude folder path : </p>
				<input type="text" name="exclude_folder_path" placeholder="Exclude folder path" required/><br/><br/>
				<p>Choose signature : </p>
				<select name="signature" required>
					<option>MD5</option>
					<option>SHA1</option>
				</select><br/><br/>
				<p>Choose compression type : </p>
				<select name="compression" required>
					<option>no compression</option>
					<option>GZIP</option>
					<option>LZO</option>
				</select>
				<br/>
				<br/>
				<br/>
				<input type="checkbox" name="fileset_change" value="fileset change"/><label for="fileset change"> Ignore FileSet Changes</label><br/>
				<br/>
				<br/>
				<br/>
				<input type="submit" id="submit" name="submit_fileset" value="Create" /> <br/> <br/>
			</form>
		</div>
	</div>
</body>
</html>