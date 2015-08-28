<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Logs - Bacula Web GUI</title>
</head>
<body>
	<script type="text/javascript">
	
	$(document).ready(function(){
   	    $('#client_table').dataTable( {
   	        "pagingType": "full_numbers",
   	     	"order": [[ 0, "desc" ]],
   	    } );
	});
	
	</script>
	<div class="container">
	<div class = "row">
	<div class="page-header">
		<h1>Logs</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Bacula logs</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
	<%
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.openConnection();
	
	String jobQuery = "SELECT * FROM Log LIMIT 2000 ;"; 
	Statement st = db_controller.getConnexion().createStatement();
	ResultSet log_rs = st.executeQuery(jobQuery);
	
	out.println("<thead>");
	out.println("<th> JobId </th>");
	out.println("<th> Date </th>");
	out.println("<th> Time </th>");
	out.println("<th> Message </th>");
	out.println("</thead>");
	
	while(log_rs.next()){
		out.println("<tr>");
		out.println("<th scope=\"row\">"+log_rs.getString("JobId"));
		out.println("</td>");
		out.println("<td>"+AppUtils.getDate(log_rs.getString("Time")));
		out.println("</td>");
		out.println("<td>"+AppUtils.getTime(log_rs.getString("Time")));
		out.println("</td>");
		out.println("<td>"+log_rs.getString("LogText"));
		out.println("</td>");
		out.println("</tr>");
	}
	log_rs.close();
	st.close();
	db_controller.closeConnection();
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