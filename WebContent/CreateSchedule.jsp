<!doctype html>
<html lang="en">

<head>
<%@ include file="navbar.jsp" %>
<title>Create schedule - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>

<body>
	<div class="container">
		<div class="page-header">
		<h1>Create Schedule</h1>
		</div>

			<form data-toggle="validator" class="form-horizontal"
				action="createservlet" method="post" novalidate>
				
				<input type="hidden" name="create_type" value="schedule">

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="fileset_name">Schedule name <font color="red">*</font> :</label>
		<input type="text" class="form-control" name="schedule_name" required />
			<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<%
		out.println(PrintJSP.printFieldInfo(Manual.getScheduleRunInfo()));
		%>
		<label for="backup_folder_path">Run <font color="red">*</font> :</label>
		<input type="text" class="form-control" name="run" required />
			<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
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