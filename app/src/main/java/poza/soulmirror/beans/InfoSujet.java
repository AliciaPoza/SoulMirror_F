package poza.soulmirror.beans;

import java.util.List;

public class InfoSujet {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private UtilisateurBean utilisateur;
    private SujetBean sujet;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */
    public InfoSujet() {
    }
    public InfoSujet(UtilisateurBean utilisateur, SujetBean sujet) {
        this.utilisateur = utilisateur;
        this.sujet = sujet;
    }
    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public UtilisateurBean getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurBean utilisateur) {
        this.utilisateur = utilisateur;
    }

    public SujetBean getSujet() {
        return sujet;
    }

    public void setSujet (SujetBean sujet) {
        this.sujet = sujet;
    }
}
