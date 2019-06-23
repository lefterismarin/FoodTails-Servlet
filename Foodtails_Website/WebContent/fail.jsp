<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>Insert title here</title>
<style>
html, body{height: 100%;}
body{
		background-image: url("oops.jpg");		
		background-repeat: no-repeat;
		background-attachment: fixed;
		background-size: 100% 100%;
		
		
	}
h2{
	text-align:center;
	}
.buttonholder{
	text-align:center;
	}
</style>
</head>
<body>
<br><br><br><br>
<%
String fail_type = (String)request.getAttribute("fail_type"); 
if(fail_type.equals("login")){
	out.println("<h2>Please check your credentials and try again.</h2>");
}
else if(fail_type.equals("register")){
	out.println("<h2>Username already exists or something is wrong with the Database. Please Try again.</h2>");
}
else if(fail_type.equals("recover")){
	out.println("<h2>Email not found. Please Try again.</h2>");
}
else{
	out.println("<h2>Critical error. Type of User not found.</h2>");
}

%>
<br>

<form method="post" action="Login.html">
<div class="buttonholder">
<input type="submit" value="OK"/>
</div>
</form>


</body>
</html>