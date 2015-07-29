<!doctype html>
<html lang="en">

<head>
	<title>Create a Job</title>
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
		<h1>Create a Job</h1>
	</div>

	<div class="form_create_job">
	<form id="form_create_job" class="form" action="createjobservlet.do" method="post" novalidate>
		<br/>
		<p>Job name : </p>
		<input type="text" name="client_name" placeholder="job name" required/><br/><br/>
		<p>Job Type : </p>
		<select name="jobType" required>
			<option>backup</option>
			<option>restore</option>
		</select>
		<p>Client : </p>
		<select name="client" required>
			<option>NetWS06-fd</option>
		</select>
		<p>FileSet : </p>
		<select name="fileset" required>
			<option>Default</option>
		</select>
		<p>Storage : </p>
		<select name="storage" required>
			<option>Default</option>
		</select>
		<p>Pool : </p>
		<select name="pool" required>
			<option>Default</option>
		</select>
		<p>Message type : </p>
		<select name="messageType" required>
			<option>Standard</option>
		</select>
		<p>Location (optional) : </p>
		<input type="text" name="where" placeholder="location"/><br/><br/>
		
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<input type="submit" id="submit" name="submit_client" value="Add" /> <br/> <br/>
	</form>
	</div>
	</div>
</body>
</html>