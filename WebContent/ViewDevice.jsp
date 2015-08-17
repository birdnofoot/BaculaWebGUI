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
       	Show Configuration File
        </a>
    </div>

    <div id="collapseThree" class="panel-collapse collapse">
      <div class="panel-body">
    <%
		out.println(AppUtils.printConfigHighlight(Constant.getDevices(),"Device"));
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