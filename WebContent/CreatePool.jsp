<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create pool - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<div class="page-header">
		<h1>Create pool</h1>
		</div>
		
			<form data-toggle="validator" class="form-horizontal"
				action="createservlet" method="post" novalidate>
				
				<input type="hidden" name="create_type" value="pool">
				<div class = "form-group">
				<div class="col-md-3">
				<label for="pool_name">Pool name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="pool_name" required />
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="pool_type">Pool type <font color="red">*</font> :</label>
				<select class="form-control" name="pool_type" required>
					<option>Backup</option>
					<option>Restore</option>
				</select>
				</div>
				</div>
				
								<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getPoolVolumeRetentionInfo()));
				%>
				<label for="volume_retention">Volume Retention <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="volume_retention" required/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getPoolMaxVolumeBytes()));
				%>
				<label for="maximum_volume_bytes">Maximum Volume Bytes <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="maximum_volume_bytes" required/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getPoolMaxVolume()));
				%>
				<label for="maximum_volumes">Maximum Volumes <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="maximum_volumes" required/>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getPoolMaxVolumeJob()));
				%>
				<label for="maximum_volume_jobs">Maximum Volume Jobs <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="maximum_volume_jobs" required/>
				</div>
				</div>
				<br/>
				
				<button type="button" class="btn btn-default" onclick="toggleContent()">Show advanced options</button>
				<div ID="advanced_form" style="display:none;">
				
				<br/>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="label_format">Recycle :</label>
				<select class="form-control" name="recycle">
					<option></option>
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="label_format">Auto Prune :</label>
				<select class="form-control" name="autoprune">
					<option></option>
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				

				
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getPoolLabelFormatInfo()));
				%>
				<label for="label_format">Label Format :</label>
				<input type="text" class="form-control" name="label_format"/>
				</div>
				</div>
				
				</div>
				<br/>
				<br/>
				<br/>
				<br/>
				<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
				</form>
				</div>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
</body>
</html>