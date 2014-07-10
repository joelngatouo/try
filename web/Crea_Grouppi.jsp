<%-- 
    Document   : Crea_Grouppi
    Created on : 04-Jan-2014, 13:23:56
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
        <title>CREA_GRUPPI</title>
         <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
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

       <form class="form-signin" action = "Insert_And_Control" ><h1> Crea Un Gruppo</h1  <form class="form-signin">
        <h3 class="form-signin-heading"></h3>
<h3 class="form-signin-heading">inserisci nome del gruppo</h3><input type="text" class="form-control"name = "nome_gruppo"> private <td><input type="checkbox" name="private" value="1"></td>
  
<div class="bs-example">
      <table class="table">
        <thead>
          <tr>
          <th>numero dell'utente</th>
          <th>nome dell'utente </th>
          <th>manda richiestà </th>
          
           </tr>
        </thead>
        <tbody>
             <tr>
            <c:forEach var="user" items="${requestScope.users}" varStatus="status"  >  
              <td><h2> <c:out value="${status.count}" /></h2></td>
            <td><h2> <c:out value="${user.userName}" /> </h2> </td>
            <td> <input type="checkbox" name="checkbox" value="${user.id}"></td>
           </tr>
           </c:forEach>
        </tbody>
      </table>
    </div>
<c:out value="${requestScope.conferma}" escapeXml="true" />
<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
           </form>

    </body>
</html>
