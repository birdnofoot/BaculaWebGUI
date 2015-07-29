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
	<h1>Create Schedule</h1>
	</div>

	<div class="form_create_schedule">
	<form id="form_create_schedule" class="form" action="createscheduleservlet.do" method="post" novalidate>
	<br/>
	<p>Schedule name : </p>
	<input type="text" name="fileset_name" placeholder="schedule name" required/><br/><br/>
	<p> Run time : </p>
	<input type="text" name="backup_folder_path" placeholder="run time" required/><br/><br/>
	<p></p>
	<br/><br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<input type="submit" id="submit" name="submit_fileset" value="Create" />
	<br/>
	<br/>
</form>
</div>
	</div>
</body>
</html>