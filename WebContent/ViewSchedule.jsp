<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<title>View Schedule - Bacula Web GUI</title>
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
   	    $('#schedule_table').dataTable( {
   	        "pagingType": "full_numbers"
   	    } );
	});
	</script>
	<div class="container">
	<div class = "row">
	<div class="page-header">
		<h1>Schedule</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Schedule</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
	<%
   	ServletContext servletContext = request.getServletContext();
	DatabaseController db_controller = (DatabaseController)servletContext.getAttribute("db_controller");
	ResultSet schedule_rs = db_controller.getSchedules();
	/*
	out.println("<thead>");
	out.println("<th> ID </th>");
	out.println("<th> Name </th>");
	out.println("<th> OS </th>");
	out.println("</thead>");
	
	while(schedule_rs.next()){
		out.println("<tr>");
		out.println("<th scope=\"row\">"+schedule_rs.getString("ClientId"));
		out.println("</td>");
		out.println("<td>"+schedule_rs.getString("Name"));
		out.println("</td>");
		out.println("<td>"+schedule_rs.getString("Uname"));
		out.println("</td>");
		out.println("</tr>");
	}*/
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