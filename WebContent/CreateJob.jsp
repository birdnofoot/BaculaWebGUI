<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create Job - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
</head>
<body>
	<div class="container">
	<div class="page-header">
		<h1>Create Job</h1>
	</div>
	
	<form class="form-horizontal"
			action="createjobservlet" method="post" novalidate>
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_name">Job name :</label>
	<input type="text" class="form-control" name="job_name" placeholder="job name"
		required />
	</div>
	</div>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="job_type">Job type :</label>
	<select class="form-control" name="job_type" required>
		<option>Backup</option>
		<option>Restore</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="client">Client :</label>
	<select class="form-control" name="client" required>
	<%
	File f = new File("/etc/bacula/conf.d/clients.conf");
	ArrayList<String> name_list = new ArrayList<String>();
	name_list = AppUtils.getName(f,"Name");
	int i = 0 ;
	for(i=0;i<name_list.size();i++){
		out.println("<option>"+name_list.get(i)+"</option>");
		System.out.println();
	}
	%>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="storage">Storage :</label>
	<select class="form-control" name="storage" required>
	<%
	File f3 = new File("/etc/bacula/conf.d/storages.conf");
	ArrayList<String> storage_list = new ArrayList<String>();
	storage_list = AppUtils.getName(f3,"Name");
	for(i=0;i<storage_list.size();i++){
		out.println("<option>"+storage_list.get(i)+"</option>");
		System.out.println();
	}
	%>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="pool">Pool :</label>
	<select class="form-control" name="pool" required>
	<%
	File f2 = new File("/etc/bacula/conf.d/pools.conf");
	ArrayList<String> pool_list = new ArrayList<String>();
	pool_list = AppUtils.getName(f2,"Name");
	for(i=0;i<pool_list.size();i++){
		out.println("<option>"+pool_list.get(i)+"</option>");
		System.out.println();
	}
	%>
	</select>
	</div>
	</div>
	
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="message_type">Message type :</label>
	<select class="form-control" name="message_type" required>
		<option>Standard</option>
	</select>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="location">Location (optional) :</label>
	<input type="text" class="form-control" name="location" placeholder="location"/>
	</div>
	</div>
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