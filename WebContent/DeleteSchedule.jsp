<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Delete Schedule - Bacula Web GUI</title>

</head>

<body>
	<div class="container">
	<div class = "row">
	
	<div class="page-header">
	<h1>Delete Schedule</h1>
	</div>

	<form class="form-horizontal"
		action="deletescheduleservlet" method="post" novalidate>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="device">Choose a pool to delete :</label>
	<br/>
	
	<select class="form-control" name="pool_name" required>
	<%
	File f = new File("/etc/bacula/conf.d/schedules.conf");
	ArrayList<String> name_list = new ArrayList<String>();
	name_list = AppUtils.getName(f,"Name");
	int i = 0 ;
	for(i=0;i<name_list.size();i++){
		out.println("<option>"+name_list.get(i)+"</option>");
		System.out.println();
	}
	%>
	</select>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Delete" />
	</div>
	</div>
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