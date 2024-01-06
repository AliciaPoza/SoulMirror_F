package poza.soulmirror.beans;

import java.util.Date;

public class MessageBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idMessage;
    private String contenuMessage;
    private Date dateMessage;
    private int idUtilisateur;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public MessageBean() {
    }

    public MessageBean(int idMessage, String contenuMessage, Date dateMessage, int idUtilisateur) {
        this.idMessage = idMessage;
        this.contenuMessage = contenuMessage;
        this.dateMessage = dateMessage;
        this.idUtilisateur = idUtilisateur;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getContenuMessage() {
        return contenuMessage;
    }

    public void setContenuMessage(String contenuMessage) {
        this.contenuMessage = contenuMessage;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
