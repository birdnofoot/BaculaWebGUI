<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<script src="http://code.highcharts.com/highcharts.js"></script>
<title>Quick guide - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
		<div class = "container">
		<div class="page-header">
		<h1>Quick guide</h1>
		</div>
		<div class="row">
		<h3>1. Bacula process</h3>
		<br/>
		<h4>Start, stop or restart bacula daemons :</h4>
		<p>Bacula doesn't take account of configuration file modification when it's not related to a job. So no changes will happen in database after modifications. As BaculaWebGUI only shows records in database, you can't see newly modified items directly from GUI.</p>
		<p>Every time an entity (Client,Storage,Job...) has been created, edited or removed, bacula daemons should be restarted to make changes effective.
		<pre># service bacula-fd restart
# service bacula-sd restart
# service bacula-director restart</pre>
		<br/>
		<h3>2. Bacula Console</h3>
		<br/>
		<h4>Open Bacula Console :</h4>
		<pre># bconsole</pre>
		
		<br/>
		
		
		<h4>Run a job : </h4>
		<p>First, open bacula console using <strong>bconsole</strong> :</p>
		<pre>
# bconsole
Connecting to Director
1000 OK : Version : 5.2.6(21 February 2012)
Enter a period to cancel a command.
*
		</pre>
		<p>Then run job by entering <strong>run</strong> :</p>
		<pre>
* run</pre>
	<p>Select a job number, and run the job.</p>
	<br/>
	
	
		<h4>Check status of director, storage or clients :</h4>
		<p>You can check status of director, storage or clients using command <strong>status</strong>:
		<pre>
# status</pre>
		<p>And choose the entity you want to check. You can also use (for example) <strong>status director</strong> to achieve this :</p>
				<pre>
# status director</pre>
		<br/>
		
		
		
		<h4>See all jobs or clients :</h4>
		<p>To see all jobs or clients in catalog by using command :</p>
		<pre>
# list jobs</pre>
<p>or :</p>
		<pre>
# list clients</pre>
		<br/>
		
		<h4>Cancel a running job :</h4>
		<p>You can cancel a running job by doing :</p>
		<pre>
# cancel</pre>
<p>Then choose a running job number to cancel.</p>
		<br/>
		
		<h4>Restore files for a client :</h4>
		<p>You can restore files for a client using command :</p>
		<pre>
# restore</pre>
<p>Then choose a jobID to restore from :</p>
<pre>
To select the JobIds, you have the following choices:
     1: List last 20 Jobs run
     2: List Jobs where a given File is saved
     3: Enter list of comma separated JobIds to select
     4: Enter SQL list command
     5: Select the most recent backup for a client
     6: Select backup for a client before a specified time
     7: Enter a list of files to restore
     8: Enter a list of files to restore before a specified time
     9: Find the JobIds of the most recent backup for a client
    10: Find the JobIds for a backup for a client before a specified time
    11: Enter a list of directories to restore for found JobIds
    12: Cancel
Select item:  (1-12):</pre>
		<br/>
		<p>Then follow instructions to mark files to restore. For more details : <a href="http://www.bacula.org/5.1.x-manuals/en/main/main/Restore_Command.html">here</a>.</p>
		<p>You can also restore <strong>all</strong> files for a client using :</p>
				<pre>
# restore all</pre>
		<p>In this case, you will not be asked to choose files. Note : Do not use <strong>run restore jobs</strong> for restoring files.</p>
		<br/>
		</div>
		</div>
</body>
</html>