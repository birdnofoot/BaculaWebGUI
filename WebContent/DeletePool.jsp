<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<%@page import="model.*"%>
<%@page import="java.sql.*"%>
<%@page import="controller.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<title>Delete Pool - Bacula Web GUI</title>
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
	<h1>Delete Pool</h1>
	</div>

	<form class="form-horizontal"
		action="deletepoolservlet" method="post" novalidate>

	<div class = "form-group">
	<div class="col-xs-3">
	<label for="recycle">Choose a pool to delete :</label>
	<br/>
	
	<select class="form-control" name="pool_name" required>
	<%
	
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.connectoDatabase();	

	String failedJobQuery = "SELECT * FROM Pool ; " ;
	Statement st = db_controller.getConnexion().createStatement();
	ResultSet pool_rs = st.executeQuery(failedJobQuery);

	while(pool_rs.next()){
		out.println("<option>"+pool_rs.getString("Name")+"</option>");
	}
	
	pool_rs.close();
	st.close();
	db_controller.closeConnection();
	%>
	</select>

	</div>
	</div>
	</form>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Delete" />
	<br/>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>