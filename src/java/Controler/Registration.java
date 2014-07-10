/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Utility.EmailManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import db.DBManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zabsa90
 */
public class Registration extends HttpServlet {

    private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
   String uploadAvatarPathAssoluta = request.getServletContext().getRealPath("/")+"avatar";
   File file = new File(uploadAvatarPathAssoluta);
                    if (!file.exists()){
                       file.mkdir();
                     }
        
    MultipartRequest multi = new MultipartRequest(request, file.toString(), 10 * 1024 * 1024,
                                         "ISO-8859-1", new DefaultFileRenamePolicy());      
               

    Boolean emailExist=manager.checkEmail((String)multi.getParameter("email"));

    if(emailExist == false){
                     
                     File f = multi.getFile("avatar"); 
                     String fileName = multi.getFile("avatar").getName();
                     
                     
                    
                    if (fileName!=null){
                       try{
                        manager.registrazione((String)multi.getParameter("username"), (String)multi.getParameter("password"), (String)multi.getParameter("email"), fileName);
                        } catch(SQLException ex){
                        
                         }
                    }
                     
                     EmailManager email =new EmailManager();
                     email.WelcomeEmail(email.ConnectEmail(), (String)multi.getParameter("email"));
                     response.sendRedirect("RegistrazioneOk.jsp");
                }
                 else{
                     request.setAttribute("emailExist", "Email gia esistente !,please insert a new one !");
                     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                     rd.forward(request, response);
                 }
      
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
