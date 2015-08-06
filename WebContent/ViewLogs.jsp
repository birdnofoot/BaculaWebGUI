<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<%@ page import="model.*"%>
<%@ page import= "utils.*" %>
<%@ page import="java.sql.*"%>
<%@ page import="controller.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
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
	<script type="text/javascript">
	$(document).ready(function(){
   	    $('#client_table').dataTable( {
   	        "pagingType": "full_numbers",
   	     	"order": [[ 0, "desc" ]]
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
   	ServletContext servletContext = request.getServletContext();
	DatabaseController db_controller = (DatabaseController)servletContext.getAttribute("db_controller");
	ResultSet log_rs = db_controller.getLogs();
	
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