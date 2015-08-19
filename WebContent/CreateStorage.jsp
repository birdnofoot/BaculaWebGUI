<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create storage - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">	
	<div class="page-header">
	<h1>Create storage</h1>
	</div>
	
	<form data-toggle="validator" class="form-horizontal" action="createstorageservlet" method="post" novalidate>
	<div class = "form-group">
	<div class="col-md-3">
	<label for="storage_name">Storage name <font color="red">*</font> :</label>
	<input type="text" class="form-control" name="storage_name" required />
	<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
	</div>
	</div>
	
	<div class = "form-group">
	<div class="col-xs-3">
	<label for="device">Device <font color="red">*</font> :</label>
	<select  class="form-control" name="device" required>
	<% out.println(AppUtils.printSelectOptionByType("device")); %>
	</select>
	</div>
	</div>
		<br/>		
	<button type="button" class="btn btn-default" onclick="toggleContent()">Show advanced options</button>
	<div ID="advanced_form" style="display:none;">
	<br/>

	<div class = "form-group">
	<div class="col-md-3">
	<span class="manual" title="<%= Manual.getStorageIpInfo() %>">
	<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
	</span>
	<label for="ip_address">IP Address : </label>
	<input type="text" class="form-control" name="ip_address" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
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