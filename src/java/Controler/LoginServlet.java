/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.User;
import db.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zabsa90
 */
public class LoginServlet extends HttpServlet {
 private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
    
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
           
        try {
            user = manager.authenticate(username, password);
        } catch (SQLException ex) {
            System.out.println("caused by"+ex.getMessage());
            throw new ServletException(ex);
            
        }
        if (user == null) {
            String strErrMsg = null;
            strErrMsg = "Username/password non esistente !";            
            
            request.setAttribute("errorMsg", strErrMsg);
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            request.setAttribute("User", user.getUserName());
             
             RequestDispatcher rd = request.getRequestDispatcher("MenuPage.jsp");
               rd.forward(request, response);
            
        }

    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
}
