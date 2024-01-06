package poza.soulmirror.beans;

import java.util.Date;

public class SignalementBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idSignalement;
    private String contenuSignalement;
    private Date dateSignalement;
    private int idUtilisateur;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public SignalementBean() {
    }

    public SignalementBean(int idSignalement, String contenuSignalement, Date dateSignalement, int idUtilisateur) {
        this.idSignalement = idSignalement;
        this.contenuSignalement = contenuSignalement;
        this.dateSignalement = dateSignalement;
        this.idUtilisateur = idUtilisateur;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        this.idSignalement = idSignalement;
    }

    public String getContenuSignalement() {
        return contenuSignalement;
    }

    public void setContenuSignalement(String contenuSignalement) {
        this.contenuSignalement = contenuSignalement;
    }

    public Date getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(Date dateSignalement) {
        this.dateSignalement = dateSignalement;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
