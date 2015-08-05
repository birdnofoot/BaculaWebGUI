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
	<div class="container">
	
		<div class="page-header">
			<h1>Console</h1>
		</div>
		
 <div> 
    <object type="text/html" data="https://localhost:4200/" width="800px" height="600px" style="overflow:auto; border:1px ridge gray">
    </object></div>
	</div>
	<br/>
	<br/>
	<br/>
</body>
</html>