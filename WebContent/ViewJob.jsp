<%@page import="database.*"%>
<%@page import="java.sql.*"%>
<%@page import="table.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>


<!doctype html>
<html lang="en">
<head>
<title>View all jobs - Bacula Web GUI</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/jquery.dataTables.css">

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
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
						aria-expanded="false">Pool <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="CreatePool.jsp">Create Pool</a></li>
							<li><a href="#">Delete Pool</a></li>
							<li><a href="#">Edit Pool</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">FileSet <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="CreateFileSet.jsp">Create FileSet</a></li>
							<li><a href="#">Delete FileSet</a></li>
							<li><a href="#">Edit FileSet</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Job <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="CreateJob.jsp">Create Job</a></li>
							<li><a href="#">Delete Job</a></li>
							<li><a href="#">Edit Job</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Schedule <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="CreateSchedule.jsp">Create Schedule</a></li>
							<li><a href="#">Delete Schedule</a></li>
							<li><a href="#">Edit Schedule</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Client <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="AddClient.jsp">Add Client</a></li>
							<li><a href="#">Delete Client</a></li>
							<li><a href="#">Edit Client</a></li>
						</ul></li>

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
						aria-expanded="false">Login <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
	<div class = "row">
	
	<div class="page-header">
	<h1>View all jobs</h1>
	</div>
	
		<script type="text/javascript">
		$(document).ready(function(){
    	    $('#pool_table').dataTable( {
    	        "pagingType": "full_numbers"
    	    } );
		});
		</script>
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
	</div>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>