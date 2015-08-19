<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View pools - Bacula Web GUI</title>
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
	<div class="page-header">
		<h1>Pool</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Pool</h3>
	</div>
	<div class="panel-body">
	<table id = "pool_table" class="table">
	<%
		DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
		db_controller.openConnection();	

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
			out.println("<td>"+AppUtils.formatTime(pool_rs.getString("VolRetention")));
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
	
	
	<div class="container">
	<div class="panel-group" id="accordion">
    <div class="panel panel-info" id="panel3">
    <div class="panel-heading">
    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
    	Show Configuration File
        </a>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
    <%
		out.println(AppUtils.printConfigHighlight(Constant.getPools(),"Pool"));
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