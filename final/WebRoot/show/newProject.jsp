<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<script type="text/javascript">
function time(){
 var t = new Date();
 //document.write(t)
 var year = t.getYear()+1900;
 var month = t.getMonth()+1;
 if(month<10){
  month = "0"+(t.getMonth()+1);
 }
 var date = t.getDate();
 if(date<10){
  date = "0"+(t.getDate());
 }
 var hours = t.getHours();
 if(hours<10){
  hours = "0"+(t.getHours());
 }
 var minutes = t.getMinutes();
 if(minutes<10){
  minutes = "0"+(t.getMinutes());
 }
 var seconds = t.getSeconds();
 if(seconds<10){
  seconds = "0"+(t.getSeconds());
 }
 //document.write(year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds);
 document.getElementById("time").innerText = "time : "+year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds+" ";
 setTimeout("time()",1000);
}
</script>
</head>

<body onload="time()">

    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" valign="middle">

<s:form action="newProject">
<table width="300" border="1" >
  <tr>
    <td align="center" valign="middle" colspan="2"> Project Name: <input type="text" name="name" value=""/>
    </td>
  </tr>
  <tr>
    <td colspan="2"><textarea name="content" cols="90" rows="50"></textarea></td>
  </tr>
  <tr>
  <td><div id="time"></div>
  </td>
  <td>
  <!--  <div id="time"></div> -->  
  <table>
  <tr><td>
   <s:submit value="submit" >  </s:submit>	
  </td></tr></table>
  
  </td>
  </tr>

 
  
</table>
</s:form>
</td></tr></table>

</body>
</html>
