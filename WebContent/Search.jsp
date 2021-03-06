<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Search - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		
		<div class="page-header">
		<h1>Search</h1>
		</div>
		
		<form class="form-horizontal"
			action="searchservlet" method="post" novalidate>
			
			<div class = "form-group">
			<div class="col-md-3">
			<%
				out.println(PrintJSP.printFieldInfo(Manual.getSearchFilenameInfo()));
			%>
			<label for="file_name">File name<font color="red"> * </font>:</label>
			<input type="text" class="form-control" name="file_name" required />
			</div>
			</div>
			<br/>
			<button type="button" class="btn btn-default" onclick="toggleContent()">Show advanced options</button>
			<div ID="advanced_form" style="display:none;">
			<br/>
			<div class = "form-group">
			<div class="col-xs-3">
			<label for="client">Client :</label>
			<select class="form-control" name="client" required>
				<option>All</option>
				<% out.println(PrintJSP.printSelectOptionByTypeNameInDB("Client")); %>
			</select>
			<br/>
			<label for="JobId">JobId :</label>
			<select class="form-control" name="JobId" required>
				<option>All</option>
				<% out.println(PrintJSP.printSelectOptionByJobId()); %>
			</select>
			
			</div>
			</div>
			</div>
			<br/>
			<br/>
			<br/>
			<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Search" />
			</form>
			</div>
			
			<script type="text/javascript">
				$(document).ready(function(){
		    	    $('#file_table').dataTable( {
		    	        "pagingType": "full_numbers",
		    	        "order": [[ 0, "desc" ]]
		    	    } );
				});
			</script>
		
			<%  
				ArrayList<FileRecord> list = new ArrayList<FileRecord>();
				if(request.getAttribute("fileList") != null){
					
					list = (ArrayList<FileRecord>)request.getAttribute("fileList");
					
					out.println("</br>");
					out.println("</br>");
					out.println("</br>");
					out.println("<div class = \"container\">");

					out.println("<div class=\"panel panel-default\">");					
					out.println("<div class = \"panel-body\">");
					out.println("<div class=\"alert alert-info\" role=\"alert\">");
					if(list.size() != 10000){
						out.println("Matched file number : "+list.size());
					}
					else{
						out.println("Max matched file display number : "+list.size());
					}
					out.println("</div>");
					out.println("<table id=\"file_table\" class=\"table\">");
					
					out.println("<thead>");
					out.println("<th> File Name </th>");
					out.println("<th> Client Name </th>");
					out.println("<th> Path </th>");
					out.println("<th> Job ID </th>");
					out.println("<th> Job Name </th>");
					out.println("<th> Start Time </th>");
					out.println("<th> End Time </th>");
					out.println("</thead>");

					
					// print the information about every category of the list
					for(FileRecord fileList : list) {
						
						out.println("<tr>");
						out.println("<th scope=\"row\">"+fileList.getFileName());
						out.println("</td>");
						out.println("<td>"+fileList.getClientName());
						out.println("</td>");
						out.println("<td>"+fileList.getPath());
						out.println("</td>");
						out.println("<td>"+fileList.getJobId());
						out.println("</td>");
						out.println("<td>"+fileList.getJobName());
						out.println("</td>");
						out.println("<td>"+AppUtils.formatDate(fileList.getStartTime()));
						out.println("</td>");
						out.println("<td>"+AppUtils.formatDate(fileList.getEndTime()));
						out.println("</td>");
						out.println("</tr>");
					    out.println();
					}			
					out.println("</table>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
				}

				%>

				<br/>
				<br/>
				<br/>
				<br/>
				<br/>

</body>
</html>