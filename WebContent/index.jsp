<!DOCTYPE html>
<html>
<head>
<%@include file="navbar.jsp" %>
<script src="http://code.highcharts.com/highcharts.js"></script>
<meta charset="UTF-8">

<title>Bacula Web GUI</title>
</head>
<body>
	<div class = "container">
 	<div class="page-header">
  	<h1>Dashboard </h1>
	</div>
		<div class="alert alert-info" role="alert">
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
		<%
			HashMap<String,Status> statusMap = new HashMap<String,Status>();
			statusMap = AppUtils.getJobStatusLong();
		
    		DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
    		db_controller.openConnection();	
		out.print("<span>&nbsp;&nbsp;Today is "+AppUtils.getDate()+". You have " +db_controller.getClientNumber()+ 
			" clients and "+db_controller.getJobNumber()+" jobs. </span>");
		%>
		</div>
		</div>
		
		
		<%-- DataTables --%>
		<script type="text/javascript">
		$(document).ready(function(){
       	    $('#job_table').dataTable( {
    	        "pagingType": "full_numbers",
        	    "order": [[ 0, "desc" ]],
       	 		"bLengthChange": false,
       	 		"iDisplayLength": 8,
       	 		"bFilter": false
    	    } );
    	    $('#failed_job_table').dataTable( {
    	        "pagingType": "full_numbers",
        	     "order": [[ 0, "desc" ]],
       	 		"bLengthChange": false,
          	 	"iDisplayLength": 5,
          	 	"bFilter": false
    	    } );
		});
		</script>


		<%-- Successful jobs --%>
		<div class = "container">
		<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">Successful jobs</h3>
		</div>
		<div class="panel-body">
		<table id="job_table" class="table">
		<%
		String jobQuery = "SELECT * FROM Job WHERE JobStatus = \"T\" order by StartTime DESC LIMIT 300 ;"; 
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet job_rs = st.executeQuery(jobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Job Name </th>");
		out.println("<th> Level </th>");
		out.println("<th> Client </th>");
		out.println("<th> File Size </th>");
		out.println("<th> Scheduled Time </th>");
		out.println("<th> Start Time </th>");
		out.println("<th> End Time </th>");
		out.println("</thead>");
		
		while(job_rs.next()){		
			out.println("<tr>");
			out.println("<th scope=\"row\">"+job_rs.getString("JobId"));
			out.println("</td>");
			out.println("<td><a style=\"color:#333\" href=\"searchservlet?JobId="+job_rs.getString("JobId")+"\">"+job_rs.getString("Name"));
			out.println("</a></td>");    
			out.println("<td>"+job_rs.getString("Level"));
			out.println("</td>");
			out.println("<td>"+db_controller.getClientNameById(job_rs.getString("ClientId")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatFileSize(job_rs.getString("JobBytes")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(job_rs.getString("SchedTime")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(job_rs.getString("StartTime")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(job_rs.getString("EndTime")));
			out.println("</td>");
			out.println("</tr>");
		}
		
		job_rs.close();
		st.close();
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
		String failedJobQuery = "SELECT * FROM Job WHERE JobStatus = \"f\" or JobStatus = \"e\" or JobStatus = \"E\"; " ;
		st = db_controller.getConnexion().createStatement();
		ResultSet failed_job_rs = st.executeQuery(failedJobQuery);
		
		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Job Name </th>");
		out.println("<th> Level </th>");
		out.println("<th> Client </th>");
		out.println("<th> File Size </th>");
		out.println("<th> Scheduled Time </th>");
		out.println("<th> Start Time </th>");
		out.println("<th> End Time </th>");
		out.println("</thead>");
		
		while(failed_job_rs.next()){		
			out.println("<tr>");
			out.println("<th scope=\"row\">"+failed_job_rs.getString("JobId"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("Name"));
			out.println("</td>");
			out.println("<td>"+failed_job_rs.getString("Level"));
			out.println("</td>");
			out.println("<td>"+db_controller.getClientNameById(failed_job_rs.getString("ClientId")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatFileSize(failed_job_rs.getString("JobBytes")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(failed_job_rs.getString("SchedTime")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(failed_job_rs.getString("StartTime")));
			out.println("</td>");
			out.println("<td>"+AppUtils.formatDate(failed_job_rs.getString("EndTime")));
			out.println("</td>");
			out.println("</tr>");
		}
		st.close();
		failed_job_rs.close();
		db_controller.closeConnection();
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