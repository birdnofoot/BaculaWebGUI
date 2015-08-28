<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Wizard - Bacula Web GUI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>

	<%
	String status = (String)request.getAttribute("status") ;
	if(status == null){
		out.println(PrintJSP.printWizardForm()); 
	}
	else{
		if(status.equals("finish")){
			out.println("<div class=\"container\">");
			out.println("<div class=\"page-header\">");
			out.println("<h1>Success</h1>");
			out.println("</div>");
			out.println("<div class=\"alert alert-info\" role=\"alert\">");
			out.println("<span> All configuration files are created with success. </span>");
			out.println("</div>");
			out.println("</div>");
		}
		if(status.equals("default")){
			out.println(PrintJSP.printWizardForm());
		}
	}
	%>
	
	
	
		
		
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>