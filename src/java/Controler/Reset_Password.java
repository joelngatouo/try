/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

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
public class Reset_Password extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String Password=request.getParameter("password");
        
        if(Password !=null){
            
        }
        else if(Password =="" && Password.length()==0){
             request.setAttribute("emptyfields", "please.. try to insert something !");
                      RequestDispatcher rd = request.getRequestDispatcher("/Reset_Password.jsp");
                         rd.forward(request, response);
        }
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
   
        
        
    }

   
}
