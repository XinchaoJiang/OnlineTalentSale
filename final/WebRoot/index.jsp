<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script language="JavaScript">

setTimeout("index.submit();",1);

</script>
   
  </head>
  
  <body>
    <s:form action="index"><s:submit style="background:url(ht1.jpg); width:100px; height:25px; border:none; text-indent:-9999px; cursor:pointer;"></s:submit>
			</s:form>

  </body>
</html>


