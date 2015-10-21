<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
  <head>
  
  <script language="JavaScript">
var s="<%=session.getAttribute("login")%>"; 
if(s=="fail"){
alert("wrong username or password");}
</script>
  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<style type="text/css">
p.a{margin-left: 0px}
p.b{margin-left: 50px}
</style>

    <title>Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/final/bootstrap-3.1.1-dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="company/companyLogin.jsp">Company login</a>
        </div>
        <div class="navbar-collapse collapse">
        
          <form action="userLogin" class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" name="name" value ="aaa"  class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="password" value="123" class="form-control">
            </div>
            
           <!-- <button type="submit" class="btn btn-success">Sign in</button> -->
           
            <button type="submit"  class="btn btn-lg btn-success">Sign in</button>
          </form>
          
        </div><!--/.navbar-collapse -->
      </div>
</div>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p><h1>Join in the UPPER!</h1>
        <p>Practice? Satisfy?</p>
        <p>No matter what you need, you can find in <em><strong>Here</strong></em>!</p>
        <p><a href="user/register.jsp" class="btn btn-primary btn-lg" role="button">Click here &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">

        <s:iterator value="#request.projects">

		<div class="col-md-4">
          <h2><s:property value="name" /></h2>
          <p class="a">PUBLISHED BY <s:property value="publisher"/></p>
          <p class="b">IN <s:property value="time"/></p>
        </div>

	</s:iterator>
        
        

      </div>

      <hr>




      <footer>
        <p>&copy; Company 2013</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  </body>
</html>
