<%-- 
    Document   : Reset_Password
    Created on : 27-dic-2013, 10.07.41
    Author     : zabsa90
--%>

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
         <div class="container">
 
      
          <h1>Reset your Password !</h1>
          <form action="Reset_Password" method="get">
    
              <fieldset class="control-group">
                    <label for="password" class="control-label">Inserisci la sua nuova password:</label>
                    <div class="controls">
                        <input type="password"  name="password" >
                    </div>
              </fieldset>
             
      <button type="submit" class="btn btn-default" >Invia</button>
    </form>
  
  <span style="color: #FF0000"> <c:out value="${requestScope.emptyfields}" escapeXml="true" /></span>

  
                             
</div>
    </body>
</html>
