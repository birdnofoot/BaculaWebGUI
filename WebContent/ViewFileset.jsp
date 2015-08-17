<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View FileSets - Bacula Web GUI</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
    	    $('#fileset_table').dataTable( {
    	        "pagingType": "full_numbers",
        	     "order": [[ 2, "desc" ]]
    	    } );
		});
	</script>
	
	<div class="container">
	<div class="page-header">
	<h1>FileSets</h1>
	</div>
	
	<div class="panel panel-info">
	<div class="panel-heading">
	<h3 class="panel-title">FileSet</h3>
	</div>
	<div class="panel-body">
	<table id = "fileset_table" class="table">
	<%
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.connectoDatabase();	

	String failedJobQuery = "SELECT * FROM FileSet ; " ;
	Statement st = db_controller.getConnexion().createStatement();
	ResultSet fileset_rs = st.executeQuery(failedJobQuery);
	
	out.println("<thead>");
	out.println("<th> ID </th>");
	out.println("<th> Name </th>");
	out.println("<th> Creation Time </th>");
	out.println("</thead>");
	
	while(fileset_rs.next()){
		out.println("<tr>");
		out.println("<th scope=\"row\">"+fileset_rs.getString("FileSetId"));
		out.println("</td>");
		out.println("<td>"+fileset_rs.getString("FileSet"));
		out.println("</td>");
		out.println("<td>"+AppUtils.formatDate(fileset_rs.getString("CreateTime")));
		out.println("</td>");
		out.println("</tr>");
	}
	
	fileset_rs.close();
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
		out.println(AppUtils.printConfigHighlight(Constant.getFilesets(),"FileSet"));
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