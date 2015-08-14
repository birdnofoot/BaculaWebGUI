<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>View all pools - Bacula Web GUI</title>
</head>

<body>

	<div class="container">
	<div class="page-header">
	<h1>Device</h1>
	</div>
	
	<script>
	$(document).ready(function(){
    $(".btn-primary").click(function(){
        $(".collapse").collapse('toggle');
    });
    $(".btn-success").click(function(){
        $(".collapse").collapse('show');
    });
    $(".btn-warning").click(function(){
        $(".collapse").collapse('hide');
    });
	});
	</script>

	<div class="panel-group" id="accordion">
    <div class="panel panel-info" id="panel3">
    <div class="panel-heading">
       <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
       	Show Configuration File [devices.conf]
        </a>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
      	<%
		File f = new File("/etc/bacula/devices.conf");
		Scanner fileScanner = new Scanner(f);
		String currentLine = null ;
		while(fileScanner.hasNext()){
        	currentLine = fileScanner.nextLine();
        	out.println(currentLine);
        	out.println("</br>");
		}
		fileScanner.close();
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