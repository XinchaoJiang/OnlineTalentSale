<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showResume.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table>
  <tr><td  colspan="3">
   <s:form action="newProject"><input type="hidden" name="action" value="go" />  <s:submit value="newProject"></s:submit></s:form>
   </td></tr>
  <tr><td>name</td><td>time</td><td></td></tr>
    <s:iterator value="#request.projectList">
   <tr>
    	<td><s:property value="name"/></td>
    	<td><s:property value="time"/></td>
    	<td> <s:form action="projectDetail">
    	<input type="hidden" name="name" value=<s:property value="name"/> />    	  	
    	<s:submit value="details"></s:submit></s:form></td>
   </tr>
   </s:iterator> 
   </table>
  </body>
</html>
