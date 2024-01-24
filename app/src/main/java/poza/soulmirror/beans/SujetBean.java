package poza.soulmirror.beans;
public class SujetBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private String titreSujet;
    private String contenuSujet;
    private String idUtilisateur;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */
    public SujetBean() {
    }
    public SujetBean(String titreSujet, String contenuSujet, String idUtilisateur) {
        this.titreSujet = titreSujet;
        this.contenuSujet = contenuSujet;
        this.idUtilisateur = idUtilisateur;
    }
    public SujetBean(String titreSujet, String contenuSujet) {
        this.titreSujet = titreSujet;
        this.contenuSujet = contenuSujet;
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
    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
