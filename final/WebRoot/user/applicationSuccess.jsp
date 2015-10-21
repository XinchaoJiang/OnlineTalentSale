

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script> 
 window.onload=function() 
 { 
 alert("apply success!");
 setInterval("redirect();",1); 
 } 
 function redirect() 
 { 
 window.location.href="/user/userIndex.jsp"; 
 } 
</script>   
  </head>
  
  <body>

  </body>
</html>


