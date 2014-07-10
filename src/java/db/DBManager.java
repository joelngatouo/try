

package db;


import Model.Gruppo;
import Model.Post;
import Model.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Anis
 */


public class DBManager implements Serializable {
    
      private transient Connection con;
    
    public DBManager(String dburl) throws SQLException {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver", true,getClass().getClassLoader());
        } catch(Exception e) {
            throw new RuntimeException(e.toString(), e);
        }
        
        this.con  = DriverManager.getConnection(dburl);
        
    }
    
    public static void shutdown() {
        try {
            
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).info(ex.getMessage());
        }
    }

  
    public User authenticate(String username, String password) throws SQLException {

   
        PreparedStatement stm = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        try {
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            try {
                if (rs.next()) {
                    User user = new User();
                    user.setUserName(username);
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setAvatar(rs.getString("avatar"));
                    return user;
                } else {
                    return null;

                }

            } finally {
                
                rs.close();
            }

        } finally {
            stm.close();
        }

    }

  /**
     * Registra un nuovo utente
     * @param usr
     * @param pwd
     * @param email
     * @param fullname
     * @param indirizzo
     * @param tel
     * @throws SQLException 
     */
    public void registrazione(String usr, String pwd, String email,String AvatarPath) throws SQLException {
   
        PreparedStatement stm = con.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD, EMAIL,ROLE,AVATAR) " +
                                                      "VALUES (?, ?, ?,?,?) " );
        try {
            stm.setString(1, usr);
            stm.setString(2, pwd);
            stm.setString(3, email);
            stm.setString(4, "normal");
            stm.setString(5,AvatarPath);
       
            stm.executeUpdate();
        } finally { 
            stm.close();
        }
    
    }
       
    
    
    public boolean checkEmail(String email) throws SQLException{
        
        
        PreparedStatement stm = con.prepareStatement("select * from USERS where email= ? " );
        try {
          stm.setString(1, email);
          ResultSet rs=stm.executeQuery();
          try {
               if (rs.next() ) {    

                 
                    return true;
                } else {
                    return false;

                }

            } finally {
                
                rs.close();
            }

        } finally {
            stm.close();
        }

}
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Gruppo> getGruppi(User u) throws SQLException {

        List<Gruppo> gruppi = new ArrayList<Gruppo>();
        int id = u.getId();
        PreparedStatement stm
                = con.prepareStatement("SELECT * FROM (gruppo g INNER JOIN user_gruppo ug ON ug.idgruppo = g.idgruppo)  INNER JOIN users u ON ug.idutente = u.id WHERE u.id = ? "
                        + "AND ug.invito > 0");

        try {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            try {

                while (rs.next()) {
                    Gruppo g = new Gruppo();
                    g. setIdPro(getUser(rs.getInt("idProp")).getId());
                    g.setNomeGruppo(rs.getString("nome"));
                    g.setDataCreazione(rs.getDate("datacreazione"));
                    g.setIdGruppo(rs.getInt("idgruppo"));
                    gruppi.add(g);
                }
            } finally {

                rs.close();
            }
        } finally {

            stm.close();
        }

        return gruppi;

    }
         public List<User> getUsers (int id) throws SQLException {

                List<User> users = new ArrayList<User>();

        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM users WHERE id != ?");
        try {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            try {
                while(rs.next()) {
                    User user = new User();
                    user.setUserName(rs.getString("username"));
                    user.setId(rs.getInt("id"));
                    users.add(user);
                } 

            } finally {
                rs.close();
            }

        } finally { 
            stm.close();
        }
        return users;
    }
         
 
  public List<Gruppo> getPropGruppo(User u) throws SQLException {

        List<Gruppo> gruppi = new ArrayList<Gruppo>();
        int id = u.getId();
        PreparedStatement stm
                = con.prepareStatement("SELECT * FROM gruppo,users  where Id =IdProp and Id =? ");

        try {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            try {

                while (rs.next()) {
                    Gruppo g = new Gruppo();
                    g.setNomeGruppo(rs.getString("nome"));
                    g.setDataCreazione(rs.getDate("datacreazione"));
                    g.setIdGruppo(rs.getInt("idgruppo"));
                    g.setIdPro(u.getId());
                    gruppi.add(g);
                }
            } finally {

                rs.close();
            }
        } finally {

            stm.close();
        }

        return gruppi;

    }
 public User getUser(int id) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * FROM USERS WHERE id = ?");
        try {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            try {
                if (rs.next()) {
                    User user = new User();
                    user.setUserName(rs.getString("USERNAME"));

                    user.setId(rs.getInt("ID"));
                    return user;
                } else {
                    return null;

                }

            } finally {
                rs.close();
            }

        } finally {
            stm.close();
        }
    }
 public int getId_User (String name) throws SQLException{
             PreparedStatement stm = con.prepareStatement("SELECT ID FROM USERS WHERE USERNAME = ?");
             try {
          ResultSet rs = stm.executeQuery();
                 try {
                     if(rs.next()){
                     int idr = rs.getInt("ID");
                     return  idr;
                     }
                     else return  1000;
                     
                 }  finally {
                     rs.close();
                 }
                 }finally{
             stm.close();
             } 
 }

    public void creaGruppo( User u , String nome,Boolean bool ) throws SQLException {
        Date data = new Date(Calendar.getInstance().getTimeInMillis());

        PreparedStatement stm = con.prepareStatement("INSERT INTO GROUPPO (ID_PROP,NOME_GRUPPO,DATA_CREAZIONE,FLAG ) values(?,?,?,?)");

        try {
             stm.setInt(1, u.getId());
            stm.setString(2, nome);
            stm.setDate(3, data);
            stm.setBoolean(4, bool);
            
            stm.executeUpdate();
        }   finally {
             stm.close();
        }
        

    }
   public int getLastGroup() throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT MAX(ID_GRUPPO) FROM GROUPPO");
        try {
            
            ResultSet rs = stm.executeQuery();

            try {
                if(rs.next()){
                int Id_Gruppo=rs.getInt(1);
                    return Id_Gruppo;
                } else {
                    return 1000;

                }

            } finally {
                rs.close();
            }

        } finally {
            stm.close();
        }
    }
 
public int AddInvito(int IdPerson ) throws SQLException{
    
    boolean accetta =false;
    PreparedStatement stm =con.prepareStatement("INSERT INTO USEGRUPPO (IDGRUPPO,IDUSER,ACCETTA) values (?,?,?)");
    int x=0;
       
        try {
            stm.setInt(1, getLastGroup());
            stm.setInt(2, IdPerson);
            stm.setBoolean(3, accetta);
           
           x=stm.executeUpdate();
        } finally {
            stm.close();
        }
        return x;
}
public List<Gruppo> Stampa_intiti(int my_id) throws SQLException{
    List<Gruppo> lista = new ArrayList<Gruppo>();
    boolean boo = false ;
            
    PreparedStatement stm = con.prepareStatement("SELECT distinct  NOME_GRUPPO,ID_GRUPPO FROM GROUPPO natural join USEGRUPPO WHERE IDGRUPPO = ID_GRUPPO and IDUSER = ?  and ACCETTA =  ?");
    try {
        stm.setInt(1, my_id);
        stm.setBoolean(2, boo);
        ResultSet rs = stm.executeQuery();
        try {
            while(rs.next()){
            Gruppo g =new Gruppo();
            g.setNomeGruppo(rs.getString(1));
            g.setIdGruppo(rs.getInt(2));
            lista.add(g);
            }
        }  finally {
            rs.close();
        }
   } finally   {
        stm.close();
    }
    
    return lista;
       
}



public void Acceta_gruppo(User user ,int idGruppo) throws SQLException{
boolean bool= true ;
PreparedStatement stm  = con.prepareStatement("UPDATE USEGRUPPO set ACCETTA = ? WHERE  IDGRUPPO = ? and  IDUSER = ? ");
    try {
        stm.setBoolean(1, bool);
        stm.setInt(2, idGruppo);
        stm.setInt(3,user.getId() );
        stm.executeUpdate();
        
    }  finally {
        stm.close();
    }
}
 public List<Gruppo> getGroups(User user) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT ID_GRUPPO,NOME_GRUPPO,ID_PROP,DATACREAZIONE  from GRUPPO g join USEGRUPPO ug on g.ID_GRUPPO=ug.IDGRUPPO join USERS u " 
                                                      +"on g.ID_PROP=u.ID where ug.IDUSER= ? and ug.ACETTA=? "
                                                       + "UNION select ID_GRUPPO ,NOME_GRUPPO,ID_PROP,DATACREAZIONE from GRUPPO g join USERS u on g.ID_PROP=u.ID where g.ID_PROP= ?");
        try {
            stm.setInt(1, user.getId());
            stm.setBoolean(2, true);
            stm.setInt(3, user.getId());

            ResultSet rs = stm.executeQuery();

            
                List<Gruppo> gruppi = new ArrayList();
                while (rs.next()){
                    Gruppo gruppo = new Gruppo();
                    gruppo.setIdGruppo(rs.getInt("ID_GRUPPO"));
                    gruppo.setNomeGruppo(rs.getString("NOME_GRUPPO"));
                    gruppo.setDataCreazione(rs.getDate("DATACREAZIONE"));
                    gruppo.setIdPro(rs.getInt("ID_PROP"));
                   
                  
                    gruppi.add(gruppo);

                } 
                return gruppi;

        } finally {
            stm.close();
        }

    }
 public Gruppo getGroup(Integer id_gruppo, User user) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT ID_GRUPPO, ID_PROP,DATACREAZIONE, NOME_GRUPPO, USERNAME FROM GRUPPO g JOIN USERS u\n" +
"                ON g.ID_GRUPPO=u.ID WHERE ID_GRUPPO = ?");
        try {
            stm.setInt(1, id_gruppo);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                Gruppo g = new Gruppo();

                g.setIdGruppo(rs.getInt("ID_GRUPPO"));
                g.setIdPro(rs.getInt("ID_PROP"));
                g.setDataCreazione(rs.getDate("DATACREAZIONE"));
                g.setNomeGruppo(rs.getString("NOME_GRUPPO"));
               
             

                return g;

            } else {
                return null;
            }

        } finally {
            stm.close();
        }

    }
   public List<Post> getPosts(Gruppo g) throws SQLException {

        List<Post> posts = new ArrayList<Post>();
        int id = g.getIdGruppo();
       
        PreparedStatement stm
                = con.prepareStatement("SELECT IDPOST,IDGRUPPO,IDPROP,TESTO,DATACREAZIONE,FILENAME FROM post WHERE idgruppo = ? ORDER BY DATACREAZIONE DESC");

        try {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            try {

                while (rs.next()) {
                    Post p = new Post();
                    p.setIdPost(rs.getInt("IDPOST"));
                    p.setIdGruppo(rs.getInt("IDGRUPPO"));
                    p.setIdProp(rs.getInt("IDPROP"));
                    p.setTesto(rs.getString("TESTO"));
                    p.setDateCreazione(rs.getDate("DATACREAZIONE"));
                    p.setFileName(rs.getString("FILENAME"));
                    
                    posts.add(p);
                }
            } finally {

                rs.close();
            }
        } finally {

            stm.close();
        }

        return posts;

    }
   
   
   
    public void addPostFile(User user, int id_gruppo,String testo,String fileName) throws SQLException {
        int idutente = user.getId();

        Date data = new Date(Calendar.getInstance().getTimeInMillis());

        PreparedStatement stm
                = con.prepareStatement("insert into POST (IDGRUPPO,IDPROP,TESTO,FILENAME,DATACREAZIONE) values (?,?,?,?,?)");

        try {
           
            stm.setString(3, testo);
            stm.setInt(2, idutente);
            stm.setInt(1, id_gruppo);
            stm.setString(4, fileName);
            stm.setDate(5, data);
            int executeUpdate = stm.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            stm.close();
        }

    }
    


}