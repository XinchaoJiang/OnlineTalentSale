<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>Web 2.0 Login Form</title>

	<!--- CSS --->
	<link rel="stylesheet" href="/final/css/style.css" type="text/css" />


	</head>

	<body>
		<div id="container">
			<s:form action="adminLogin">
				<div class="login">ENTERPRISE LOGIN</div>
				<div class="username-text">Account:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<input type="text" name="name" value="acs" />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="123456" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>
				<div class="forgot-usr-pwd">for administrator only</div>
				<s:submit value="GO"></s:submit>
			</s:form>
		</div>
		<div id="footer">
		</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' 
charset='gb2312'></script></div>
</body>
</html>