
<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Restart Bacula Daemon - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<style type="text/css">
.panel-body{
  overflow-y:scroll;
  width:100%;
}
</style>
</head>
<body>
<script type="text/javascript" src="js/bootstrap-select.js"></script>
	<div class="container">

	<%
	ArrayList<String>[] output = (ArrayList<String>[])new ArrayList[2] ;
	ArrayList<String> cmd_output = new ArrayList<String>();
	ArrayList<String> error_output = new ArrayList<String>();
	if(request.getAttribute("cmd_output") != null){
			out.println("<div class=\"page-header\">");
			out.println("<h1>Done</h1>");
			out.println("</div>");
			out.println("<div class=\"alert alert-info\" role=\"alert\">");
			out.println("<span> The restart has been launched. Check log below for detail. </span>");
			out.println("</div>");

		output = (ArrayList<String>[])request.getAttribute("cmd_output");
		cmd_output = output[0];
		error_output = output[1];
		int i = 0 ;%>
		<div class="panel panel-default">

		<div id="log" class="panel-body" style="min-height: 450px; max-height: 450px;">
		<%
		for(i=0;i<cmd_output.size();i++){
			out.println(cmd_output.get(i)+"<br/>");
		}
		for(i=0;i<error_output.size();i++){
			out.println(error_output.get(i)+"<br/>");
		}%>
		</div>
		</div>
		<%
	}
	else{
	%>
	<div class="page-header">
		<h1>Restart Bacula Daemon</h1>
	</div>
	
	<%
	DatabaseController db_controller = (DatabaseController)application.getAttribute("db_controller");
	db_controller.openConnection();	
	
	if(db_controller.getRunningJobNumber() != 0){
		out.println("<div class=\"alert alert-warning\" role=\"alert\">");
		out.println("<span class=\"glyphicon glyphicon-warning-sign\" aria-hidden=\"true\"></span>");
		out.print("<span>&nbsp;&nbsp; <a href=\"View.jsp?type=Job\" style=\"color:#8a6d3b\">You have running jobs at the moment. Restarting daemons will stop all running jobs.</a></span>");
		out.println("</div>");
		}
	db_controller.closeConnection();
	%>
	
<form data-toggle="validator" class="form-horizontal" action="restartdaemonservlet" method="post" novalidate>
		<div class = "form-group">
		<div class="col-xs-6">
		<h4>Choose a daemon to restart :</h4>
	<br/>
	<script type="text/javascript">
	$('#select-all').click(function(event) {   
	    if(this.checked) {
	        // Iterate each checkbox
	        $(':checkbox').each(function() {
	            this.checked = true;                        
	        });
	    }
	});
	</script>
	
	<div class="checkbox">
	  <label><input type="checkbox" name="bacula_sd" value="1">Bacula Storage Daemon (bacula-sd)</label>
	</div>
	<div class="checkbox">
	  <label><input type="checkbox" name="bacula_fd" value="1">Bacula File Daemon (bacula-fd)</label>
	</div>
	<div class="checkbox">
	  <label><input type="checkbox" name="bacula_director" value="1">Bacula Director Daemon (bacula-director)</label>
	</div>
    <br/>
    <br/>
    </div>
	<br/>
	</div>
	<br/>
	<br/>
	<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Restart" />
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	</form>
		<%} %>
	</div>
		<script type="text/javascript">
		var div = document.getElementById("log");
		div.scrollTop = div.scrollHeight;
	</script>
</body>
</html>