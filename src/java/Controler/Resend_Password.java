/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Utility.EmailManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zabsa90
 */
public class Resend_Password extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        
      
        if(username!=null){
            
        }
        else if(email!=null){
            String Ogetto="Reset your password please !";
            String testo="Welcome press this in order to reset your password :http://localhost:8084/JSTLExer/Reset_Password.jsp";
            
            EmailManager emailm = new EmailManager();
            emailm.sendMail(emailm.ConnectEmail(), email,Ogetto , testo);
            
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            
        }
        else{
             request.setAttribute("emptyfields", "please.. try to insert something !");
                      RequestDispatcher rd = request.getRequestDispatcher("resend_password.jsp");
                         rd.forward(request, response);
        
        
        } 
    }

  
}
