<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>Web 2.0 Login Form by Azmind.com</title>

	<!--- CSS --->
	<link rel="stylesheet" href="/final/css/style.css" type="text/css" />

	</head>

	<body>
		<div id="container">
			<div class="welcome">
				<div class="welcome-user">Hello! 
				<s:text name="name" />!
				</div>
				
		<!--  	<div class="welcome-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</div> -->
				<div class="welcome-text"><br/>Welcome back!<br/><br/><br/><br/><br/><br/></div>
				<div class="home">				<a href="adminDeleteProject">Delete</a>				</div>
				<div class="home2">				<a href="adminAddCompany">Add</a>				</div>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>