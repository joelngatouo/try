<%-- 
    Document   : resend_password
    Created on : 27-dic-2013, 8.07.26
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
 
       <div class="resend-password-wrapper">
          <h1>Hai dimenticato la password?</h1>
          <form action="Resend_Password" method="post">
    
              <fieldset class="control-group" id="email_or_phone_fieldset">
                    <label for="email" class="control-label">Inserisci il tuo indirizzo email:</label>
                    <div class="controls">
                      <input type="text" id="email" name="email" autocomplete="on">
                
                    </div>
              </fieldset>
              
      <div class="separator">
        &mdash;O&mdash;
      </div>
              
             <fieldset class="control-group" id="screen_name_fieldset">
                    <label for="screen_name" class="control-label">Inserisci il tuo nome utente:</label>
                    <div class="controls">
                      <span class="input-prepend">
                        <span class="add-on"><i class="tweet-at"></i></span>
                        <input type="text" id="screen_name" name="name" autocomplete="on" class="username-prepended-input">
                      </span>
                     
                    </div>
                      
             </fieldset>
            
      <button type="submit" class="btn btn-default" >Invia</button>
    </form>
  </div>
 
  
                             
</div>
 <span style="color: #FF0000"> <c:out value="${requestScope.emptyfields}" escapeXml="true" /></span>
    </body>
</html>
