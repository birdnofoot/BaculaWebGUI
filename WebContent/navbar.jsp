<%-- Java classes --%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="utils.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sun.org.apache.xml.internal.serializer.utils.Utils"%>

<%-- CSS --%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/jquery.dataTables.css">

<%-- JavaScript --%>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

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
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Device<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewDevice.jsp">View devices</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateDevice.jsp">Create device</a></li>
						<li><a href="DeleteDevice.jsp">Delete device</a></li>
					</ul>
				</li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Storage<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewStorage.jsp">View storages</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateStorage.jsp">Create storage</a></li>
						<li><a href="DeleteStorage.jsp">Delete storage</a></li>
					</ul>
				</li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Pool<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewPool.jsp">View pools</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreatePool.jsp">Create pool</a></li>
						<li><a href="DeletePool.jsp">Delete pool</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">FileSet<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewFileset.jsp">View filesets</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateFileSet.jsp">Create fileset</a></li>
						<li><a href="DeleteFileSet.jsp">Delete fileset</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Job<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewJob.jsp">View jobs</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateJob.jsp">Create job</a></li>
						<li><a href="DeleteJob.jsp">Delete job</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Schedule<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewSchedule.jsp">View schedules</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateSchedule.jsp">Create schedule</a></li>
						<li><a href="DeleteSchedule.jsp">Delete schedule</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Client<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewClient.jsp">View clients</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="AddClient.jsp">Add client</a></li>
						<li><a href="DeleteClient.jsp">Delete client</a></li>
					</ul>
				</li>
				
				<li><a href="ViewLogs.jsp" role="button" aria-haspopup="true"
					aria-expanded="false">Logs</a>
				</li>
				
				<li><a href="Console.jsp" role="button" aria-haspopup="true"
					aria-expanded="false">Console</a>
				</li>
			</ul>

		</div>
	</div>
</nav>
<br/>
<br/>
<br/>