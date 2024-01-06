package poza.soulmirror.beans;

import java.util.Date;

public class CommentaireBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */

    private int idCommentaire;
    private String contenuCommentaire;
    private Date dateCommentaire;
    private int idSujet;
    private int idUtilisateur;

    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public CommentaireBean() {
    }

    public CommentaireBean(int idCommentaire, String contenuCommentaire, Date dateCommentaire, int idSujet, int idUtilisateur) {
        this.idCommentaire = idCommentaire;
        this.contenuCommentaire = contenuCommentaire;
        this.dateCommentaire = dateCommentaire;
        this.idSujet = idSujet;
        this.idUtilisateur = idUtilisateur;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getContenuCommentaire() {
        return contenuCommentaire;
    }

    public void setContenuCommentaire(String contenuCommentaire) {
        this.contenuCommentaire = contenuCommentaire;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public int getIdSujet() {
        return idSujet;
    }

    public void setIdSujet(int idSujet) {
        this.idSujet = idSujet;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
