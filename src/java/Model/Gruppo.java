package Model;




import java.io.PrintWriter;
import java.sql.Date;

/**
 *
 * @author Anis
 */
public class Gruppo {

    private int idgruppo;
    private int idprop;
    private String nome;
    private Date dataCreazione;
   
    

    public int getIdGruppo() {
        return idgruppo;
    }
   
    public int getIdProp() {
        return idprop;
    }
 
    public String getNomeGruppo() {
        return nome;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setIdGruppo(int idgruppo) {
        this.idgruppo = idgruppo;
    }
    
     public void setIdPro(int idprop) {
        this.idprop = idprop;
    }
     
    public void setNomeGruppo(String nome) {
        this.nome = nome;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    

}
