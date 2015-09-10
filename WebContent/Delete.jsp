<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<% String type = request.getParameter("type") ;%>
<title>Delete <%=type %> - Bacula Web GUI</title>

</head>

<body>
	<div class="container">
	<div class="page-header">
	<h1>Delete <%=type %></h1>
	</div>
	
	<form class="form-horizontal"
		action="deleteservlet" method="post" novalidate>

	<div class = "form-group">
	<div class="col-xs-3">
	<input type="hidden" id="thisField" name="deleteType" value="<%=type %>">
	<label for="job">Choose a <%=type %> to delete :</label>
	<br/>
	
	<select class="form-control" name="name" required>
	<%
		out.println(PrintJSP.printNameJSP(type));
	%>
	</select>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Delete" />
	</div>
	</div>
	</form>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>