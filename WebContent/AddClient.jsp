<!doctype html>
<html lang="en">

<head>
	<title>Add Client</title>
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
	<h1>Add a Client</h1>
	</div>

	<div class="form_add_client">
	<form id="form_add_client" class="form" action="addclientservlet.do" method="post" novalidate>
		<br/>
		<p>Client name : </p>
		<input type="text" name="client_name" placeholder="client name" required/><br/><br/>
		<p>Client IP Address : </p>
		<input type="text" name="address" placeholder="IP address" required/><br/><br/>
		<p>File Daemon Port (9102 By default) : </p>
		<input type="text" name="fdPort" placeholder="File deamon port" /><br/><br/>
		<p>Catalog : </p>
		<select name="catalog" required>
			<option>MyCatalog</option>
		</select><br/><br/>
		<p>Password : </p>
		<input type="password" name="password" placeholder="Password" /><br/><br/>
		<p>File Retention (ex. 30 days) : </p>
		<input type="text" name="fileRetention" placeholder="File retention" /><br/><br/>
		<p>Job Retention (ex. 6 months) : </p>
		<input type="text" name="jobRetention" placeholder="Job retention" /><br/><br/>
		<br/>
		<input type="checkbox" name="autoPrune" value="autoPrune"/><label for="autoPrune">Enable AutoPrune</label><br/>
		<br/>
		<br/>
		<br/>
		<input type="submit" id="submit" name="submit_client" value="Add" /> <br/> <br/>
	</form>
	</div>
	</div>
</body>
</html>