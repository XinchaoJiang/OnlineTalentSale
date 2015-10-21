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


  </head>
  
  <body>
    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" valign="top">

  <table width="554" height="210" border="1">
  
   <s:iterator value="#request.project">
  <tr>
    <td height="42" align="center" valign="middle">name: <s:property value="name"/></td>
    <td>time:<s:property value="time"/></td>
    <td align="center" valign="middle">				    <s:form action="deleteProject"><input type="hidden" name="name" value=<s:property value="name"/> ><s:submit value="delete"></s:submit>
			</s:form>		</td>
  </tr>
  <tr>
<td colspan="3"><s:property value="description"/></td>  </tr>
     </s:iterator> 
  
</table>
</tr></table>
  </body>
  
  


</html>
