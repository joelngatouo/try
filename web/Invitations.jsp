<%-- 
    Document   : ShowGroup
    Created on : 05-Jan-2014, 12:56:32
    Author     : joel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
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
        <title>JSP Page</title>
    </head>
    <body>
       <div  class = "container " >
<nav class="navbar navbar-default" role="navigation">
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="MenuPage.jsp">Menu page</a>
  </div>
<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
      <ul class="nav navbar-nav">
        <li>
          <a href="invitations"> Invitations</a>
        </li>
        <li class="active">
        <li>
          <a href=" crea_gruppo">crea gruppo</a>
        </li>
        <li>
          <a href=" Gruppi">gruppi</a>
        </li>
        <li>
          <a href="../customize">Customize</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        </li>
      </ul>
    </nav>
  </div>
</header>

       <form class="form-signin" action = "ControlUpdate" ><h1> GRUPPI IN CUI SEI STATO INVITATO</h1  <form class="form-signin">
         
      
  
<div class="bs-example">
      <table class="table">
        <thead><br>
          <tr>
          <th>numero del Gruppo</th>
          <th>nome del grouppo </th>
          <th>manda richiestà </th>
           </tr>
        </thead>
         <tr>
            <c:forEach var="gruppo" items="${requestScope.elt}" varStatus="status"  >  
              <td><h2> <c:out value="${status.count}" /></h2></td>
            <td><h2> <c:out value="${ gruppo.getNomeGruppo()}" /> </h2> </td>
            <td> <input type="checkbox" name="checkbox" value="${gruppo.getIdGruppo()}"></td>
           </tr>
           </c:forEach>
           </table>
     </div>
           <button class="btn btn-lg btn-primary btn-block" type="submit">submit</button>
                    
             
           </form>
        <tbody>
    </body>
</html>
