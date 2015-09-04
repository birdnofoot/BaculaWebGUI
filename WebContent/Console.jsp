<!DOCTYPE html>
<%@page import="java.io.Console"%>
<html>
<head>
<%@ include file="navbar.jsp" %>
<meta charset="UTF-8">
<title>Console - Bacula Web GUI</title>
<style type="text/css">
.panel-body{
  overflow-y:scroll;
  width:100%;
}
</style>
</head>
<body>
	<div class="container">
	<div class="page-header">
	<h1>Console</h1>
</div>
 <div>
 
	<div class="panel panel-default">
	<div class="panel-body" style="min-height: 450px; max-height: 450px;">
	<%

	%>	
	</div>
	</div>
	    
	<form data-toggle="validator" class="form-horizontal" action="createclientservlet" method="post" novalidate>
	
	<div class = "form-group">
	<div class="col-xs-6">
	<label for="client_name">Command :</label>
	<input type="text" class="form-control" name="command" />
	</div>
	</div>
	</form>

    </div>
	</div>
	<br/>
	<br/>
	<br/>
</body>
</html>