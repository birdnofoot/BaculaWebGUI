<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<% String type = request.getParameter("type") ;%>
<title>View <%=type %> - Bacula Web GUI</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
    	    $('#table').dataTable( {
    	        "pagingType": "full_numbers",
    	        "order": [[ 0, "desc" ]]
    	    } );
		});
	</script>
	
	<div class="container">
	<div class="page-header">
		<h1><%=type %></h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title"><%=type %></h3>
	</div>
	<div class="panel-body">
	<table id="table" class="table">
	<%
		if(type.equals("Job")){
			out.println(PrintJSP.printViewJob());
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