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
	String path = AppUtils.getConfigPathByType(type);
	System.out.println(type);
	File f = new File(path);
	ArrayList<String> name_list = new ArrayList<String>();
	name_list = BaculaParser.getName(f,"Name");
	int i = 0 ;
	for(i=0;i<name_list.size();i++){
		out.println("<option>"+name_list.get(i)+"</option>");
	}
	
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