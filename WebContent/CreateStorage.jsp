<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create Storage - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<div class = "row">
		
		<div class="page-header">
		<h1>Create Storage</h1>
		</div>
		
			<form data-toggle="validator" class="form-horizontal"
				action="createstorageservlet" method="post" novalidate>
				<div class = "form-group">
				<div class="col-md-3">
				<label for="storage_name">Storage name <font color="red">*</font> :</label>
				<input type="text" class="form-control" name="storage_name" placeholder="storage name"
					required />
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>

				<div class = "form-group">
				<div class="col-md-3">
				<label for="storage_name">IP Address <font color="red">*</font> : </label>
				<input type="text" class="form-control" name="ip_address" placeholder="IP"
					required />
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="labelmedia">Device <font color="red">*</font> :</label>
				<select  class="form-control" name="device" required>
				<%
					int i; 
					File f3 = new File("/etc/bacula/devices.conf");
					ArrayList<String> storage_list = new ArrayList<String>();
					storage_list = AppUtils.getName(f3,"Name");
					for(i=0;i<storage_list.size();i++){
						out.println("<option>"+storage_list.get(i)+"</option>");
						System.out.println();
					}
				%>
				</select>
				</div>
				</div>
				
				<div class = "form-group">
				<div class="col-xs-3">
				<label for="labelmedia">Media Type <font color="red">*</font> :</label>
				<select  class="form-control" name="media_type" required>
					<option>File</option>
				</select>
				</div>
				</div>

				<br/>
				<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Create" />
				</form>
				</div>
				</div>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
</body>
</html>