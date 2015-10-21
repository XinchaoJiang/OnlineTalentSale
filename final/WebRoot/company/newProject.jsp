
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

<body onload="time()">

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
<s:form action="newProject">
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>Project Name: <input type="text" name="name" value=""/></h2>
        <p class="lead"><div id="time"> </div></p>
                      <textarea name="content" cols="160" rows="20"></textarea>
      
              <p>
       <input type="hidden" name="action" value="aaa" /> <button type="submit" class="btn btn-lg btn-success">New Project </button>
        </p>
        
        
      </div>

      
</s:form>
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

