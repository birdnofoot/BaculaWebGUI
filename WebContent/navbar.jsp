
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Bacula Web GUI</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Pool<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewPool.jsp">View pools</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreatePool.jsp">Create pool</a></li>
						<li><a href="EditPool.jsp">Edit pool</a></li>
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
						<li><a href="#">Edit fileset</a></li>
						<li><a href="#">Delete fileset</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Job<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewJob.jsp">View jobs</a></li>
					  	<li role="separator" class="divider"></li>
					  	<li><a href="CreateJob.jsp">Run backup</a></li>
						<li><a href="CreateJob.jsp">Run restore</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateJob.jsp">Create job</a></li>
						<li><a href="#">Edit job</a></li>
						<li><a href="#">Delete job</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Schedule<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewSchedule.jsp">View schedules</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="CreateSchedule.jsp">Create schedule</a></li>
						<li><a href="#">Edit schedule</a></li>
						<li><a href="#">Delete schedule</a></li>
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Client<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewClient.jsp">View clients</a></li>
					  	<li role="separator" class="divider"></li>
						<li><a href="AddClient.jsp">Add client</a></li>
						<li><a href="#">Edit client</a></li>
						<li><a href="#">Delete client</a></li>
					</ul>
				</li>
				
				<li><a href="ViewLogs.jsp" role="button" aria-haspopup="true"
					aria-expanded="false">Logs</a>
				</li>
				
				<li><a href="Console.jsp" role="button" aria-haspopup="true"
					aria-expanded="false">Console</a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Login<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">Setting</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Log out</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
