package Utility;

import java.security.Security;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Anis   145810
 */
public class EmailManager {
    
    private static final long serialVersionUID = 1L;
   // static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AdminServlet.class);
    
    
     public final boolean gmail = true; 
     public Session ConnectEmail(){
     if(gmail){
         
           Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
           Properties props = System.getProperties();
           props.setProperty("mail.smtp.host", "smtp.gmail.com");
     //      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
           props.setProperty("mail.smtp.socketFactory.fallback", "false");
           props.setProperty("mail.smtp.starttls.enable", "true");
           props.setProperty("mail.smtp.port", "587");
         //  props.setProperty("mail.smtp.socketFactory.port", "465");
           props.put("mail.smtp.auth", "true");
           props.put( "mail.debug", "true" ); 
           
           final String username = "zabsa90@gmail.com";
           final String password = "0021624150028";
           Session session = Session.getInstance(props, new Authenticator(){
               protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                    }   
               }                                        );
     
         return session;
       }else{
         
          java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
          Properties props = new Properties();
          props.put("mail.smtp.host", "mail.unitn.it");
          props.put("mail.smtp.port","587");
          props.put("mail.debug", "true");
          props.put("mail.smtp.debug", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.transport.protocol", "smtp");
          props.put("mail.smtp.socketFactory.port", "587");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.socketFactory.fallback", "false");
          final String username = "anis.nouri-1@unitn.it";
          /*-> PWD FINE RIGA*/                                                                                                                                                                            final String password = "";
          Authenticator auth = new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication(){
                  return new PasswordAuthentication(username,password);//TODO mettere PWD
              }
          };
         Session session = Session.getInstance(props,auth);
         return session;
       }
     }
     
     public void WelcomeEmail(Session session,String Email){
        try{
            if(gmail){
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("zabsa90@gmail.com"));
                msg.setRecipients(Message.RecipientType.TO,
                      InternetAddress.parse(Email,false));
                msg.setSubject("Registrazione Avvenuta");
                msg.setText("Grazie per esserti registrato al nostro sito: Adesso può iniziara l'avventura con noi");
                msg.setSentDate(new Date());
                Transport.send(msg);
                System.out.println("the email has been succesufully sent");
            }
            else{
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("info@unitn.it"));
                msg.setRecipients(Message.RecipientType.TO,
                      InternetAddress.parse(Email,false));
                msg.setSubject("Registrazione Avvenuta");
                msg.setText("Grazie per esserti registrato al nostro sito: Adesso può iniziara l'avventura con noi");
                msg.setSentDate(new Date());
                
                
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp-auth.bris.ac.uk","","");
                transport.sendMessage(msg,msg.getAllRecipients());
                transport.close();
            }
            
        }catch(MessagingException e){
        //    log.error(e);
            System.out.println("the erooooooooooooooor is "+e.getMessage());
        }
     
     }
     
     
     public void sendMail(Session session, String email, String oggetto, String txt) {
        
        try{
            if(gmail==false){
                
                MimeMessage message = new MimeMessage(session);
                InternetAddress from = new InternetAddress("zabsa90@gmail.com");
                message.setFrom(from);
                InternetAddress to = new InternetAddress(email);
                message.addRecipient(Message.RecipientType.TO, to);
                message.setSubject("Test from JavaMail.");
                message.setText("Hello from JavaMail!");
                message.saveChanges();
                Transport transport = session.getTransport("SMTP");
                transport.connect("smtp.gmail.com","","");
                transport.send(message,message.getAllRecipients());
                transport.close();
                
            }else{
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("zabsa90@gmail.com" + ""));
                msg.setRecipients(Message.RecipientType.TO,
                      InternetAddress.parse(email,false));
                msg.setSubject(oggetto);
                msg.setText(txt);
                msg.setSentDate(new Date());
                Transport.send(msg);
            }
            
        }catch(MessagingException e){
          //  log.error(e);
            System.out.println("the erooooooooooooooor 2 is "+e.getMessage());
        }
        
     }
     
     
    public void sendMails(Session session, InternetAddress[] emails, String oggetto, String txt) {
        
        
        try{
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("zabsa90@gmail.com" + ""));
            
            msg.setRecipients(Message.RecipientType.TO, emails);
            
            msg.setSubject(oggetto);
            msg.setText(txt);
            msg.setSentDate(new Date());
            msg.saveChanges();
            Transport.send(msg);
            
        }catch(MessagingException e){
       //     log.error(e);
            System.out.println("the erooooooooooooooor 3 is "+e.getMessage());
        }
        




        
     }
     
}
