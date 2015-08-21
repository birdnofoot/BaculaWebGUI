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
		out.println(PrintJSP.printWizardOption()); 
	}
	else{
		if(status.equals("finish")){
			out.println("created with success");
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