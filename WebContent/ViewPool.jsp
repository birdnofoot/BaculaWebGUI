<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<title>View all pools - Bacula Web GUI</title>
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
	   	    $('#pool_table').dataTable( {
	   	        "pagingType": "full_numbers"
	   	    } );
		});
	</script>
	<div class="container">
	<div class = "row">
	<div class="page-header">
		<h1>Pools</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Pool</h3>
	</div>
	<div class="panel-body">
	<table id = "pool_table" class="table">
	<%
		DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
		db_controller.connectoDatabase();	

		String failedJobQuery = "SELECT * FROM Pool ; " ;
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet pool_rs = st.executeQuery(failedJobQuery);

		out.println("<thead>");
		out.println("<th> ID </th>");
		out.println("<th> Name </th>");
		out.println("<th> Type </th>");
		out.println("<th> Volume Retention </th>");
		out.println("<th> Use Once </th>");
		out.println("<th> Recycle </th>");
		out.println("<th> AutoPrune </th>");
		out.println("<th> Label Format </th>");
		out.println("</thead>");
		
		while(pool_rs.next()){
			out.println("<tr>");
			out.println("<th scope=\"row\">"+pool_rs.getString("PoolId"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("Name"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("PoolType"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("VolRetention"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("UseOnce"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("Recycle"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("AutoPrune"));
			out.println("</td>");
			out.println("<td>"+pool_rs.getString("LabelFormat"));
			out.println("</td>");
			out.println("</tr>");
		}
		
		pool_rs.close();
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