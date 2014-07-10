<%-- 
    Document   : index
    Created on : 29-nov-2013, 19.59.48
    Author     : Benny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
   <link type="text/css" href="css/bootstrap.css" rel="StyleSheet">
  <link type="text/css" href="css/signin.css" rel="StyleSheet">
  <link href="../../dist/css/bootstrap.css" rel="stylesheet">
   <title>Login Page</title>
   <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
  </head>
  <body>
 <div class="container">
 <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h1>
					Welcome in Social Notes !?
				</h1>
				<p>
					Here you can simply accede to all the groups and discus and share you experience with the people .. with a sample click !
				</p>
				
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
                            <legend class="visuallyhidden">Nuovo su Social Notes? Iscriviti</legend>

			<form class="form-horizontal" method="POST" action="Registration" enctype='multipart/form-data' >
                            
                                 <div class="form-group">
			               <label >Name</label><input name="username" type="text" class="form-control" />

				</div>
				
                                <div class="form-group">
					 <label>Email address</label><input name="email" type="email" class="form-control" />
				</div>
                                <div class="form-group">
                                              <span style="color: #FF0000"> <c:out value="${requestScope.emailExist}" escapeXml="true" /></span>
                                </div>
				<div class="form-group">
					 <label>Password</label><input name="password" type="password" class="form-control"  />
				</div>
				<div class="form-group">
                                         <label for="exampleInputFile">Avatar</label><input type="file" id="exampleInputFile" name="avatar" />					
				</div>
			
				 <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
            <div class="col-md-3 column"></div>
		<div class="col-md-5 column">
                            <legend class="visuallyhidden text-center">Accedi !</legend>
                          
                            <form class="form-horizontal" method="GET" action="LoginServlet">
                            
				<div class="form-group">
					 <label  class="col-sm-2 control-label">Username</label>
					<div class="col-sm-10">
                                            <input type="text" name ="username" class="form-control"  />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" id="inputPassword3" />
					</div>
				</div>
                                <div class="form-group">
                                              <span style="color: #FF0000"> <c:out value="${requestScope.errorMsg}" escapeXml="true" /></span>
                                </div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						        <a class="forgot" href="resend_password.jsp">Hai dimenticato la password?</a>

					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>

 
  </body>
</html>
