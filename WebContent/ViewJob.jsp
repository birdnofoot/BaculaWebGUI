<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View all jobs - Bacula Web GUI</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
    	    $('#job_table').dataTable( {
    	        "pagingType": "full_numbers",
    	        "order": [[ 0, "desc" ]]
    	    } );
		});
	</script>
	
	<div class="container">
	<div class="page-header">
		<h1>Jobs</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">All jobs</h3>
	</div>
	<div class="panel-body">
	<table id="job_table" class="table">
	<%
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.connectoDatabase();
	
	String failedJobQuery = "SELECT * FROM Job ; " ;
	Statement st = db_controller.getConnexion().createStatement();
	ResultSet job_rs = st.executeQuery(failedJobQuery);
	
	out.println("<thead>");
	out.println("<th> ID </th>");
	out.println("<th> Job Name </th>");
	out.println("<th> Level </th>");
	out.println("<th> Status </th>");
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
		out.println("<td>"+job_rs.getString("Name"));
		out.println("</td>");
		out.println("<td>"+job_rs.getString("Level"));
		out.println("</td>");
		out.println("<td>"+job_rs.getString("JobStatus"));
		out.println("</td>");
		out.println("<td>"+db_controller.getClientNameById(job_rs.getString("ClientId")));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatFileSize(job_rs.getString("JobBytes")));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatDate(job_rs.getString("SchedTime")));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatDate(job_rs.getString("StartTime")));
		out.println("</td>");
		if(!job_rs.getString("JobStatus").equals("R")){
			out.println("<td>"+AppUtils.formatDate(job_rs.getString("EndTime")));
			out.println("</td>");
		}
		else{
			out.println("<td> running...");
			out.println("</td>");
		}
		out.println("</tr>");
	}
	
	job_rs.close();
	st.close();
	db_controller.closeConnection();
	
	%>
    </table>
	</div>
	</div>
	</div>

	<div class="container">
	<div class="panel-group" id="accordion">
    <div class="panel panel-info" id="panel3">
    <div class="panel-heading">
    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
    	Show Configuration File
        </a>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
    <%
		out.println(AppUtils.printConfigHighlight(Constant.getJobs(),"Job"));
	%>
	</div>
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