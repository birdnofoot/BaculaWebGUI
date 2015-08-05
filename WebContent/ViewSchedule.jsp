<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>


<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
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
	<div class="container">
	<div class = "row">
	
	<div class="page-header">
	<h1>Schedule</h1>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function(){
   	    $('#client_table').dataTable( {
   	        "pagingType": "full_numbers"
   	    } );
	});
	</script>
		<div class="panel panel-info">
	<div class="panel-heading">
	<h3 class="panel-title">Client</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
	
	<%
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
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
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>