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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joel
 */
public class Insert_And_Control extends HttpServlet {
 private DBManager manager;   @Override
 
    public void init() throws ServletException {
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         HttpSession session=request.getSession(false);
         PrintWriter out = response.getWriter();
         User user =(User)session.getAttribute("user");
         List<User> users =new ArrayList<User>();
         String  nome =request.getParameter("nome_gruppo");
         String[] flag = request.getParameterValues("private");
         String[] checkboxes = request.getParameterValues("checkbox");
         boolean control = false ;
         
         
         if(flag != null)
         control = true ;
         else control = false ;
             try{
              manager.creaGruppo(user,nome,control );
         } catch (Exception e) {
         }
             if(checkboxes!=null){
         for(int j = 0 ;j < checkboxes.length;j++){
                 try {
                      manager.AddInvito(  Integer.parseInt(checkboxes[j].toString()));
                         
                 } catch (Exception e) {
                 
                 }
                 request.setAttribute("conferma", "l'operazione è andata a buon fine");
         }  
    }
    
        RequestDispatcher rd = request.getRequestDispatcher("Crea_Grouppi");
                    rd.forward(request, response);
    
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}