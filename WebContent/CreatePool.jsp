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
	<h1>Create Pool</h1>
	</div>

	<div class="form_create_fileset">
	<form id="form_create_fileset" class="form" action="createfilesetservlet.do" method="post" novalidate>
	<br/>
	<p>Pool name : </p>
	<input type="text" name="fileset_name" placeholder="pool name" required/>
	<br/>
	<br/>
	<p>Pool type : </p>
	<select name="signature" required>
		<option>Backup</option>
		<option>Restore</option>
	</select><br/><br/>
	<p>Recycle : </p>
	<select name="compression" required>
		<option>no</option>
		<option>yes</option>
	</select>
	<p>AutoPrune : </p>
	<select name="compression" required>
		<option>no</option>
		<option>yes</option>
	</select>
	<p>Volume Retention (ex. 365 days) : </p>
	<input type="text" name="fileset_name" placeholder="volume retention" required/>
	<br/>
	<p>Maximum Volumes (ex. 100) : </p>
	<input type="text" name="fileset_name" placeholder="maximum volumes" required/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<input type="submit" id="submit" name="submit_fileset" value="Create" /> <br/> <br/>
</form>
</div>
	</div>
</body>
</html>