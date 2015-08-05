<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>


<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View all clients - Bacula Web GUI</title>
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
	<h1>Logs</h1>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function(){
   	    $('#client_table').dataTable( {
   	        "pagingType": "full_numbers",
   	     	"order": [[ 3, "desc" ]]
   	    } );
	});
	</script>
		<div class="panel panel-info">
	<div class="panel-heading">
	<h3 class="panel-title">Bacula logs</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
	
	<%
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		String logQuery = "SELECT * FROM Log; " ;
		ResultSet log_rs = m.query(logQuery);
	
	out.println("<thead>");
	out.println("<th> ID </th>");
	out.println("<th> JobId </th>");
	out.println("<th> Time </th>");
	out.println("<th> Message </th>");
	out.println("</thead>");
	
	while(log_rs.next()){
		out.println("<tr>");
		out.println("<th scope=\"row\">"+log_rs.getString("LogId"));
		out.println("</td>");
		out.println("<td>"+log_rs.getString("JobId"));
		out.println("</td>");
		out.println("<td>"+log_rs.getString("Time"));
		out.println("</td>");
		out.println("<td>"+log_rs.getString("LogText"));
		out.println("</td>");
		out.println("</tr>");
	}
	m.closeConnection(); 
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