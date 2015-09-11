<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<% 
String type = request.getParameter("type") ;
String showType = type ;
if(showType.equals("UpcomingJobs")){
	showType = "Upcoming Jobs";
}
%>
<title>View <%=showType %> - Bacula Web GUI</title>
</head>
<body>
	<% if(!type.equals("UpcomingJobs")){
	%>
	<script type="text/javascript">
		$(document).ready(function(){
    	    $('#table').dataTable( {
    	        "pagingType": "full_numbers",
    	        "order": [[ 0, "desc" ]]
    	    } );
		});
	</script>
	<%}else{ %>
		<script type="text/javascript">
		$(document).ready(function(){
    	    $('#table').dataTable( {
    	        "pagingType": "full_numbers",
    	        "order": [[ 0, "asc" ]]
    	    } );
		});
	</script>
	<%} %>
	
	<div class="container">
	<div class="page-header">
		<h1><%=showType %></h1>
	</div>
	
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">
		<%=showType	%>
		</h3>
	</div>
	<div class="panel-body">
	<table id="table" class="table">
	<%
		if(type.equals("Job")){
			out.println(PrintJSP.printViewJob());
		}
		else if(type.equals("UpcomingJobs")){
		out.println(PrintJSP.printUpcomingJobs());
		}
		else if(type.equals("Client")){
			out.println(PrintJSP.printViewClient());
		}
		else if(type.equals("FileSet")){
			out.println(PrintJSP.printViewFileset());
		}
		else if(type.equals("Pool")){
			out.println(PrintJSP.printViewPool());
		}
		else{
			out.println("See configuration file below for detail.");
		}
	%>
	</table>
	</div>
	</div>
	</div>
    <%
    	if(!type.equals("UpcomingJobs")){
    %>
	<div class="container">
	<div class="panel-group" id="accordion">
    <div class="panel panel-info" id="panel3">
    <div class="panel-heading">
    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
    	Show configuration file
        </a>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
	<%
    	out.println(AppUtils.printConfigHighlight(AppUtils.getConfigPathByType(type),type));
    	}
	%>
	</div>
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