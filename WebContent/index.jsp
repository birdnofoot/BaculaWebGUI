<%@page import="database.*"%>
<%@page import="java.sql.*"%>
<%@page import="table.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/jquery.dataTables.css">

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<title>Bacula Web GUI</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Bacula Web GUI</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Pool<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewPool.jsp">View pool</a></li>
						  	<li role="separator" class="divider"></li>
							<li><a href="CreatePool.jsp">Create pool</a></li>
							<li><a href="#">Edit pool</a></li>
							<li><a href="#">Delete pool</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">FileSet<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewFileset.jsp">View filesets</a></li>
						  	<li role="separator" class="divider"></li>
							<li><a href="CreateFileSet.jsp">Create fileset</a></li>
							<li><a href="#">Edit fileset</a></li>
							<li><a href="#">Delete fileset</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Job<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewJob.jsp">View jobs</a></li>
							<li><a href="ViewRunningJob.jsp">View running jobs</a></li>
						  	<li role="separator" class="divider"></li>
							<li><a href="CreateJob.jsp">Create job</a></li>
							<li><a href="#">Edit job</a></li>
							<li><a href="#">Delete job</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Schedule<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewSchedule.jsp">View schedules</a></li>
						  	<li role="separator" class="divider"></li>
							<li><a href="CreateSchedule.jsp">Create schedule</a></li>
							<li><a href="#">Edit schedule</a></li>
							<li><a href="#">Delete schedule</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Client<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ViewClient.jsp">View clients</a></li>
						  	<li role="separator" class="divider"></li>
							<li><a href="AddClient.jsp">Add client</a></li>
							<li><a href="#">Edit client</a></li>
							<li><a href="#">Delete client</a></li>
						</ul>
					</li>
					
					<li><a href="ViewLogs.jsp" role="button" aria-haspopup="true"
						aria-expanded="false">Logs</a>
					</li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Login<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class = "container">

 	<div class="page-header">
  	<h1>Dashboard </h1>
	</div>

		<div class="panel panel-info">
		<div class="panel-heading">
		<h3 class="panel-title">Job</h3>
		</div>
		<div class="panel-body">
		
		<script type="text/javascript">
		$(document).ready(function(){
    	    $('#job_table').dataTable( {
    	        "pagingType": "full_numbers"
    	    } );
    	    
    	    
    		$('#client_table').DataTable();
		});
		</script>
		
		<table id="job_table" class="table">

		<%
		/*
		String[] env = {"PATH=/bin:/usr/bin/"};
		String cmd = "ls";  //e.g test.sh -dparam1 -oout.txt
		Process process = Runtime.getRuntime().exec(cmd, env);
		out.println(Runtime.getRuntime().exec(cmd, env).toString());
		
		   
	        Runtime runtime = Runtime.getRuntime();
	        Process process = runtime.exec("/usr/bin/bconsole");
	        InputStream is = process.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	   
	        while ((line = br.readLine()) != null) {
	          out.println("<p>"+line+"</p>");
	        }
	    */
		DatabaseManager m = new DatabaseManager();
		m.connectoDatabase();
		String jobQuery = "SELECT * FROM Job; " ;
		ResultSet job_rs = m.query(jobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> Client </th>");
		out.println("<th> Start Time </th>");
		out.println("<th> End Time </th>");
		out.println("</thead>");
		
		while(job_rs.next()){
			out.println("<tr>");
			out.println("<th scope=\"row\">"+job_rs.getString("JobId"));
			out.println("</td>");
			out.println("<td>"+job_rs.getString("Name"));
			out.println("</td>");
			out.println("<td>"+job_rs.getString("ClientId"));
			out.println("</td>");
			out.println("<td>"+job_rs.getString("StartTime"));
			out.println("</td>");
			out.println("<td>"+job_rs.getString("EndTime"));
			out.println("</td>");
			out.println("</tr>");
		}
	%>

    </table>
	</div>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
	<h3 class="panel-title">Client</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
			<%
		String clientQuery = "SELECT * FROM Client; " ;
		ResultSet client_rs = m.query(clientQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> OS </th>");
		out.println("</thead>");
		
		while(client_rs.next()){
			out.println("<tr>");
			out.println("<th scope=\"row\">"+client_rs.getString("ClientId"));
			out.println("</td>");
			out.println("<td>"+client_rs.getString("Name"));
			out.println("</td>");
			out.println("<td>"+client_rs.getString("Uname"));
			out.println("</td>");
			out.println("</tr>");
		}
		m.closeConnection(); 
	%>

	</table>
	</div>
	</div>
	</div>
	<br/>
	<br/>
	<br/>
</body>
</html>