<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View Client - Bacula Web GUI</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function(){
   	    $('#client_table').dataTable( {
   	        "pagingType": "full_numbers"
   	    } );
	});
	</script>
	<div class="container">
	<div class="page-header">
		<h1>Clients</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Client</h3>
	</div>
	<div class="panel-body">
	<table id = "client_table" class="table">
	<%
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.connectoDatabase();	

	String failedJobQuery = "SELECT * FROM Client ; " ;
	Statement st = db_controller.getConnexion().createStatement();
	ResultSet client_rs = st.executeQuery(failedJobQuery);
	
	out.println("<thead>");
	out.println("<th> ID </th>");
	out.println("<th> Name </th>");
	out.println("<th> Agent version </th>");
	out.println("<th> AutoPrune </th>");
	out.println("<th> File Retention </th>");
	out.println("<th> Job Retention</th>");
	out.println("</thead>");
	
	while(client_rs.next()){
		out.println("<tr>");
		out.println("<th scope=\"row\">"+client_rs.getString("ClientId"));
		out.println("</td>");
		out.println("<td>"+client_rs.getString("Name"));
		out.println("</td>");
		out.println("<td>"+client_rs.getString("Uname"));
		out.println("</td>");
		out.println("<td>"+client_rs.getString("AutoPrune"));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatTime(client_rs.getString("FileRetention")));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatTime(client_rs.getString("JobRetention")));
		out.println("</td>");
		out.println("</tr>");
	}
	
	client_rs.close();
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
		out.println(AppUtils.printConfigHighlight(Constant.getClients(),"Client"));
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