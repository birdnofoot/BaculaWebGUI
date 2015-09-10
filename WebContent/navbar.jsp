<%-- Java classes --%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="utils.*"%>
<%@page import="view.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sun.org.apache.xml.internal.serializer.utils.Utils"%>

<%-- CSS --%>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/jquery.dataTables.css">

<%-- JavaScript --%>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/highchart.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<%-- JS hover text --%>
<script>
$(function() {
    var overPopup = false;
    $('[rel=popover]').popover({
        trigger: 'manual',
        placement: 'top'

    }).mouseover(function (e) {
        $('[rel=popover]').not('#' + $(this).attr('id')).popover('hide');
        var $popover = $(this);
        $popover.popover('show');

        $popover.data('popover').tip().mouseenter(function () {
            overPopup = true;
        }).mouseleave(function () {
            overPopup = false;
            $popover.popover('hide');
        });

    }).mouseout(function (e) {
        var $popover = $(this);
        setTimeout(function () {
            if (!overPopup) {
                $popover.popover('hide');
            }
        }, 200);
    });
});
</script>

<%-- JS hide form --%>
<script type="text/javascript">
	function toggleContent() {
	var contentId = document.getElementById("advanced_form");
	contentId.style.display == "none" ? contentId.style.display = "block" : 
	contentId.style.display = "none"; 
	}
</script>

<%-- JS tooltip --%>
<script>
$(".manual").tooltip({
	placement: "top"
	});
</script>		
				
<%-- Navbar --%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Bacula Web GUI v1.0</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Director<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="Information.jsp">Information</a></li>
              		<li role="separator" class="divider"></li>

              		<li class="dropdown-submenu">
              			
              			<a href="#">Device</a>
              			<ul class="dropdown-menu">
                    	<li><a href="View.jsp?type=Device">View Device</a></li>
                    	<li role="separator" class="divider"></li>
                    	<li><a href="CreateDevice.jsp">Create Device</a></li>
                    	<li><a href="Delete.jsp?type=Device">Delete Device</a></li>
                    	</ul>
                    	</li>
                    	
                    	<li class="dropdown-submenu">
                    	<a href="#">Storage</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=Storage">View Storage</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="CreateStorage.jsp">Create Storage</a></li>
						<li><a href="Delete.jsp?type=Storage">Delete Storage</a></li>
                    	</ul>
                    	</li>
                    	
                    	<li class="dropdown-submenu">
                    	<a href="#">Pool</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=Pool">View Pool</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreatePool.jsp">Create Pool</a></li>
						<li><a href="Delete.jsp?type=Pool">Delete Pool</a></li>
                    	</ul>
                    	</li>
                    	
                    	<li class="dropdown-submenu">
                    	<a href="#">FileSet</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=FileSet">View FileSet</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateFileSet.jsp">Create FileSet</a></li>
						<li><a href="Delete.jsp?type=FileSet">Delete FileSet</a></li>
                    	</ul>
                    	</li>
                    	
                    	<li class="dropdown-submenu">
                    	<a href="#">JobDefs</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=JobDefs">View JobDefs</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateJobDefs.jsp">Create JobDefs</a></li>
						<li><a href="Delete.jsp?type=JobDefs">Delete JobDefs</a></li>
                    	</ul>
                    	</li>
                    	                    	
                    	<li class="dropdown-submenu">
                    	<a href="#">Job</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=Job">View Job</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateJob.jsp">Create Job</a></li>
						<li><a href="Delete.jsp?type=Job">Delete Job</a></li>
                    	</ul>
                    	</li>

                    	<li class="dropdown-submenu">
                    	<a href="#">Schedule</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=Schedule">View Schedule</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateSchedule.jsp">Create Schedule</a></li>
						<li><a href="Delete.jsp?type=Schedule">Delete Schedule</a></li>
                    	</ul>
                    	</li>

                    	<li class="dropdown-submenu">
                    	<a href="#">Client</a>
              			<ul class="dropdown-menu">
						<li><a href="View.jsp?type=Client">View Client</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateClient.jsp">Create Client</a></li>
						<li><a href="Delete.jsp?type=Client">Delete Client</a></li>
                    	</ul>
                    	</li>

	                    <li role="separator" class="divider"></li>
              			<li><a href="Logs.jsp">Logs</a></li>
					</ul>
				</li>

				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Wizard<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="Wizard.jsp">Add new host</a></li>
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Run<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="RunJob.jsp">Run job</a></li>
						<li><a href="RestartDaemon.jsp">Restart Bacula Daemon</a></li>
					</ul>
				</li>
					
				<li><a href="Search.jsp" role="button" aria-haspopup="true"
					aria-expanded="false">Search</a>
				</li>
						
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Bacula<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="Guide.jsp">Quick guide</a></li>
						<li><a href="./files/Console.pdf">Bacula Console Commands</a></li>
						<li><a href="http://blog.bacula.org/documentation/documentation/">Bacula online manual</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
<br/>
<br/>
<br/>