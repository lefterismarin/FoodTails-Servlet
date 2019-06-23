<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
<style>
html, body{height: 100%;}
body{
		background-image: url("background2.jpg");		
		background-repeat: no-repeat;
		background-attachment: fixed;
		background-size: 100% 100%;
		
		
	}
h3 {
	color: black;
	}
.navbar{
		overflow: hidden;
		background-color: #f95f00;
		position: fixed;
		top: 10;
		width: 100%;
		}
		
.navbar a{
		float: left;
		display: block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none;
		font-size: 17px;
		font-weight: bold;
		}
		
.navbar a:hover{
				background: #332e2b;
				color: white;
				font-weight: bold;
				}
				
.navbar-right {
				float: right;
			  }
#container {
			font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
			border-collapse: collapse;
			width: 100%;
			}
#container td, #container th {
							border: 1px solid #ddd;
							padding: 8px;
							}
#container tr  {
							background-color:#f2f2f2;
							}
#container tr:hover{
					background-color:#ddd;
					}
#container th {
				padding-top: 12px;
				padding-bottom: 12px;
				text-align: left;
				background-color: #4CAF50;
				color: white;
				}
</style>
</head>
<body>
<% 
String type_user = (String)request.getAttribute("type_user"); 
String username = (String)request.getAttribute("username");
String error = (String)request.getAttribute("error");
if(error != null){
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Wrong Old Password given');");
	out.println("</script>");
}
%>

<div class="navbar">
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=<%out.print(type_user); %>&tab=MainPage&username=<%out.print(username);%>" class="brand-logo right">FoodTails</a>

<% if(type_user.equals("Admin")){%>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Admin&tab=Restaurants&username=Admin"> Manage Restaurants</a>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Admin&tab=Users&username=Admin"> Manage Users</a>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Admin&tab=ManageCritics&username=Admin"> Manage Critics</a>
<% }%>
<% if(type_user.equals("User")){%>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=User&tab=Restaurants&username=<%out.print(username);%>"> Restaurants</a>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=User&tab=MyCritics&username=<%out.print(username);%>"> My Critics</a>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=User&tab=ManageAccount&username=<%out.print(username);%>"> Manage Account</a>
<% }%>
<% if(type_user.equals("Restaurant Owner")){%>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Restaurant Owner&tab=Restaurants&username=<%out.print(username);%>"> My Restaurants</a>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Restaurant Owner&tab=ManageAccount&username=<%out.print(username);%>"> Manage Account</a>
<% }%>
<% if(type_user.equals("guest")){%>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Guest&tab=Restaurants"> Restaurants</a>
<% }%>
<div class="navbar-right">
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=<%out.print(type_user); %>&tab=Contact&username=<%out.print(username);%>">Contact</a>
<% if(type_user.equals("guest")){ %>
<a href="Register.html">Sing Up</a>
<% }
else {%>
<a href="Login.html">Log out</a>
<% }%>
</div>
</div>
<br><br><br><br>
<%

try{
	Connection con = mainPackage.ConnectionProvider.getCon();
	PreparedStatement stmt;
	stmt = con.prepareStatement("Select * FROM users WHERE username=?");
	stmt.setString(1,username);
	ResultSet rs = stmt.executeQuery();
	out.println("<table id=\"container\"><tr><th>Username</th><th>Surname</th><th>Name</th><th>Email</th><th>Type</th></tr>");
		while(rs.next())
		{
			 out.println("<tr>");
	         out.println("<td>"+rs.getString("username")+"</td>");
	         out.println("<td>"+rs.getString("surname")+"</td>");
	         out.println("<td>"+rs.getString("name")+"</td>");
	         out.println("<td>"+rs.getString("email")+"</td>");
	         out.println("<td>"+rs.getString("type")+"</td>");
	         out.println("</tr>");
		}
		out.println("</table>");
}
catch(Exception e) {
	out.println(e);
	 
}
%>
<br><br>
<form action="manage_account">
<input type="hidden" name="type" value="Delete"/>
<input type="hidden" name="type_user" value="<%out.println(type_user);%>"/>
<input type="hidden" name="username" value="<%out.println(username);%>"/>
<input type="submit" value="Delete Account"/><br><br>
</form>
<form action="manage_account">
<label>Old Password </label><input type="password" name="old_pass" required/>
<label>New Password </label><input type="password" name="new_pass" required/>
<input type="hidden" name="type" value="Change"/>
<input type="hidden" name="type_user" value="<%out.println(type_user);%>"/>
<input type="hidden" name="username" value="<%out.println(username);%>"/>
<input type="submit" value="Change Password"/>
</form>
</body>
</html>