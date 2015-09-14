<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create device - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>

	<div class="container">	
		<div class="page-header">
		<h1>Create device</h1>
		</div>
		
			<form data-toggle="validator" class="form-horizontal"
				action="createservlet" method="post" novalidate>
				
				<input type="hidden" name="create_type" value="device">
				<div class = "form-group">
				<div class="col-md-3">
				<label for="device_name">Device name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="device_name" required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<%
				out.println(PrintJSP.printFieldInfo(Manual.getDeviceLabelMediaInfo()));
				 %>
				<label for="label_media">Label Media <font color="red">*</font> :</label>
				<select  class="form-control" name="label_media">
					<option>yes</option>
					<option>no</option>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				
			    <%
				out.println(PrintJSP.printFieldInfo(Manual.getDeviceArchiveDeviceInfo()));
				 %>
				<label for="archive_device">Archive Device <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="archive_device" required/>
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>

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