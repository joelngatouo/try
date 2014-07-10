<%-- 
    Document   : MenuPage
    Created on : 24-dic-2013, 9.44.16
    Author     : zabsa90
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
   <div  class = "container " >
      
       <img src="avatar/${user.getAvatar()}" alt="Avatar" width="150" height="150"/> 
       <h1> Welcome ${user.getUserName()} your Last acess was </h1> 
       
       <div class="bs-example">
                  
           <ul>
           <li><h1> <a href="Invitations"><h1>Inviti </a> </h1>  </li>
            <li><h1> <a href="Gruppi"><h1>Gruppi</a></h1> </td>  </li>
            <h1> <a href="Crea_Grouppi"><h1>Crea gruppo</a></h1> </td        
            <li><h1> <a href="LogoutServlet"><h1>log out</h1></a></br></h1>  </li>                              
          </ul>
       

    </div>
        
    </body>
</html>
