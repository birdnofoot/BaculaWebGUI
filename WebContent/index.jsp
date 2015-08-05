<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="navbar.jsp" %>
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
	<div class = "container">

 	<div class="page-header">
  	<h1>Dashboard </h1>
	</div>
		<div class="alert alert-info" role="alert">
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span><span>&nbsp;&nbsp;You have 3 clients</span>
		</div>
		<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">Last ten successful jobs</h3>
		</div>
		<div class="panel-body">
		
		<script type="text/javascript">
		$(document).ready(function(){
    	    $('#failed_job_table').dataTable( {
    	        "pagingType": "full_numbers",
        	     "order": [[ 5, "desc" ]]
    	    } );
    	    $('#running_job_table').dataTable( {
    	        "pagingType": "full_numbers",
        	     "order": [[ 5, "desc" ]]
    	    } );
		});
		</script>
		
		<table id="job_table" class="table">

		<%
		/*
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("sudo /usr/sbin/bconsole");
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        
        while ((line = br.readLine()) != null) {
          out.println("<p>"+line+"</p>");
        }
        */
        
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		String jobQuery = "SELECT * FROM Job WHERE JobStatus = \"T\" ORDER BY StartTime DESC LIMIT 10;"; 
		ResultSet job_rs = m.query(jobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> Client </th>");
		out.println("<th> Job Status </th>");
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
	
	<div class="container">
	<div class="panel panel-danger">
	<div class="panel-heading">
	<h3 class="panel-title">Failed jobs</h3>
	</div>
	<div class="panel-body">
	<table id = "failed_job_table" class="table">
	<%
		m.connectoDatabase();
		String failedJobQuery = "SELECT * FROM Job WHERE JobStatus = \"f\"; " ;
		ResultSet failed_job_rs = m.query(failedJobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> Client </th>");
		out.println("<th> Job Status </th>");
		out.println("<th> Start Time </th>");
		out.println("<th> End Time </th>");
		out.println("</thead>");
		
		while(failed_job_rs.next()){
			out.println("<tr>");
			out.println("<th scope=\"row\">"+failed_job_rs.getString("JobId"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("Name"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("ClientId"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("JobStatus"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("StartTime"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("EndTime"));
			out.println("</td>");
			out.println("</tr>");
		}
	%>

	</table>
	</div>
	</div>

	<div class="panel panel-info">
	<div class="panel-heading">
	<h3 class="panel-title">Running jobs</h3>
	</div>
	<div class="panel-body">
	<table id = "running_job_table" class="table">
	<%
		m.connectoDatabase();
		String runningJobQuery = "SELECT * FROM Job WHERE JobStatus = \"R\"; " ;
		ResultSet running_job_rs = m.query(runningJobQuery);

		if(!running_job_rs.next()){
			out.println("<p> No running job at the moment. </p>");
		}
		else {
			out.println("<thead>");
			out.println("<th> ID </th>");
			out.println("<th> Name </th>");
			out.println("<th> Client </th>");
			out.println("<th> Job Status </th>");
			out.println("<th> Start Time </th>");
			out.println("<th> End Time </th>");
			out.println("</thead>");
			
			while(running_job_rs.next()){
				out.println("<tr>");
				out.println("<th scope=\"row\">"+running_job_rs.getString("JobId"));
				out.println("</td>");
				out.println("<td>"+running_job_rs.getString("Name"));
				out.println("</td>");
				out.println("<td>"+running_job_rs.getString("ClientId"));
				out.println("</td>");
				out.println("<td>"+running_job_rs.getString("JobStatus"));
				out.println("</td>");
				out.println("<td>"+running_job_rs.getString("StartTime"));
				out.println("</td>");
				out.println("<td>"+running_job_rs.getString("EndTime"));
				out.println("</td>");
				out.println("</tr>");
			}
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