
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession sessions=request.getSession();
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Justified Nav Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/final/bootstrap-3.1.1-dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="justified-nav.css" rel="stylesheet">

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

      <div class="masthead">
        <h3 class="text-muted"><%=sessions.getAttribute("name")%></h3>
        <ul class="nav nav-justified">
          <li><a href="../company/companyIndex.jsp">Home</a></li>
          <li class="active"><a href="../company/toShowProjects.jsp">Projects</a></li>
          <li><a href="../company/service.jsp">Services</a></li>
          <li><a href="../company/about.jsp">About</a></li>
         <li><a href="../company/contact.jsp">Contact</a></li>
                     <li><a href="../logout.jsp">Log out</a></li>         
          
        </ul>
      </div>



      <!-- Example row of columns -->
      <div class="row">
      
      
        
    <s:iterator value="#request.applicantList">
<div class="col-lg-4">
    	<h2><s:property value="userName"/></h2>
    	<p><s:property value="time"/></p>
    	<p> <s:form action="companyShowResume">
    	<input type="hidden" name="name" value=<s:property value="userName"/> />
    	<button type="submit" class="btn btn-primary">View Resume &raquo;</button></s:form>
    	</p>
    	</div>
   </s:iterator> 
      
    </div>
    
      <!-- Site footer -->
      <div class="footer">
      <br/>
        <p>&copy; Company 2013</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>

