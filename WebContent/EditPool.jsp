<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Edit Pool - Bacula Web GUI</title>
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
		<h1>Edit Pool</h1>
		</div>

		<div class = "form-group">
		<div class="col-xs-3">
		<label for="recycle">Choose a pool to edit :</label>
		<br/>
		<select class="form-control" name="recycle" required>
		
		<%

		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		String poolQuery = "SELECT * FROM Pool; " ;
		ResultSet pool_rs = m.query(poolQuery);

		while(pool_rs.next()){
			out.println("<option>"+pool_rs.getString("Name")+"</option>");
		}
		
		m.closeConnection(); 
	%>
	
	</select>
	</div>
	</div>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Edit" />
	<br/>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>