package Model;

import java.io.Serializable;

/**
 *
 * @author Anis
 */
public class User implements Serializable {

    private int id;
    private String userName;
    private String password;
    private String email;
    private String Avatar;
    

    public int getId() {
        return id;
    }
    
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
        
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the Avatar
     */
    public String getAvatar() {
        return Avatar;
    }

    /**
     * @param Avatar the Avatar to set
     */
    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }
    
    
}