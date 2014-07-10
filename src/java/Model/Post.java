/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;

/**
 *
 * @author tiessa
 */
public class Post {
    
    
    private int idPost ;
    private int idGruppo;
    private int idProp;
    private Date dateCreazione;
    private String testo;
    private String fileName;

    /**
     * @return the idPost
     */
    public int getIdPost() {
        return idPost;
    }

    /**
     * @param idPost the idPost to set
     */
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    /**
     * @return the idGruppo
     */
    public int getIdGruppo() {
        return idGruppo;
    }

    /**
     * @param idGruppo the idGruppo to set
     */
    public void setIdGruppo(int idGruppo) {
        this.idGruppo = idGruppo;
    }

    /**
     * @return the idProp
     */
    public int getIdProp() {
        return idProp;
    }

    /**
     * @param idProp the idProp to set
     */
    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    /**
     * @return the dateCreazione
     */
    public Date getDateCreazione() {
        return dateCreazione;
    }

    /**
     * @param dateCreazione the dateCreazione to set
     */
    public void setDateCreazione(Date dateCreazione) {
        this.dateCreazione = dateCreazione;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }
    
     /**
     * @return the testo
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param testo the testo to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
