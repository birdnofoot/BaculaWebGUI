<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
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
	
	<div class="container">
	<div class = "row">
	
	<div class="page-header">
	<h1>Jobs</h1>
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
    	        "pagingType": "full_numbers",
    	        "order": [[ 6, "desc" ]]
    	    } );
		});
		</script>
		
		<table id="job_table" class="table">
		<%
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		String jobQuery = "SELECT * FROM Job ;"; 
		ResultSet job_rs = m.query(jobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> Client </th>");
		out.println("<th> Job Status </th>");
		out.println("<th> Job Bytes </th>");
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
			out.println("<td>"+job_rs.getString("JobStatus"));
			out.println("</td>");
			out.println("<td>"+job_rs.getString("JobBytes"));
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