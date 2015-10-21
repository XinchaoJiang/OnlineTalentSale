
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession sessions=request.getSession();
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Narrow Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/final/bootstrap-3.1.1-dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/final/bootstrap-3.1.1-dist/css/jumbotron-narrow.css" rel="stylesheet" type="text/css">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
         <li   class="active"><a href="toUserHome">Home</a></li>
          <li><a href="userShowProjects">Projects</a></li>
          <li><a href="user/userAccount.jsp">Account</a></li>
           <li><a href="logout">Log out</a></li>               
        </ul>
        <h3 class="text-muted"> 
        <%=sessions.getAttribute("name")%>
</h3>
      </div>



    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" valign="top">

  <table width="500" height="210" border="0">
   <s:iterator value="#request.resumeList">
  <tr>
    <td height="42" align="center" valign="middle">time: <s:property value="time"/></td>
    <td align="center" valign="middle">				    <s:form action="userNewResume"><input type="hidden" name="action" value="go" />
    <button type="submit" class="btn btn-default"> submit new resume </button>
			</s:form>		</td>
  </tr>
  <tr>
<td colspan="3"><s:property value="Content"/></td>  </tr>
     </s:iterator> 
  
</table>
</tr></table>

      <div class="footer">
        <p>&copy; Company 2013</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>