<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.checked {
  color: orange;
}

html, body{height: 100%;}
body{
		background-image: url("background2.jpg");		
		background-repeat: no-repeat;
		background-attachment: fixed;
		background-size: 100% 100%;
		
		
	}
h4 {
	color: #39000d;
	text-align: center;
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
if(username == null){
	username="Guest";
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
<% if(type_user.equals("Guest")){%>
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=Guest&tab=Restaurants"> Restaurants</a>
<% }%>
<div class="navbar-right">
<a href="http://localhost:8080/Foodtails_Website/ManageDisplay?type_user=<%out.print(type_user); %>&tab=Contact&username=<%out.print(username);%>">Contact</a>
<% if(type_user.equals("Guest")){ %>
<a href="Register.html">Sing Up</a>
<% }
else {%>
<a href="Login.html">Log out</a>
<% }%>
</div>
</div>
<br><br><br><br>


<h4>Main Pageldfkjhvdgvhdghgdfkjvhjdghjgvjhgfd gvhjgfvhj djgvdfhv hjdgjvjdgvhjgd vdgfjg dfgvkj jdfxj dfvkjdsgvdjhgdfh gvhjgxhj dfvjdgvhjddddddddddvjdgfvjgkh dgvjdgkjvxhjgvxhcgvjhdg vhjdfgvhjgxvhjgd</h4>







</body>
</html>