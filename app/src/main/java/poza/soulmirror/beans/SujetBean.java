package poza.soulmirror.beans;


import java.util.Date;

public class SujetBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private String titreSujet;
    private String contenuSujet;
    private int idUtilisateur;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */
    public SujetBean() {
    }

    public SujetBean(String titreSujet, String contenuSujet) {
        this.titreSujet = titreSujet;
        this.contenuSujet = contenuSujet;
    }

    public SujetBean(String titreSujet, String contenuSujet, int idUtilisateur) {
        this.titreSujet = titreSujet;
        this.contenuSujet = contenuSujet;
        this.idUtilisateur = idUtilisateur;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */
    public String getTitreSujet() {
        return titreSujet;
    }
    public void setTitreSujet(String titreSujet) {
        this.titreSujet = titreSujet;
    }
    public String getContenuSujet() {
        return contenuSujet;
    }
    public void setContenuSujet(String contenuSujet) {
        this.contenuSujet = contenuSujet;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
