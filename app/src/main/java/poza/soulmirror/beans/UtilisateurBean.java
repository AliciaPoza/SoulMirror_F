package poza.soulmirror.beans;

public class UtilisateurBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String pseudoUtilisateur;
    private String emailUtilisateur;
    private String motDePasseUtilisateur;

    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public UtilisateurBean() {
    }

    public UtilisateurBean(String nomUtilisateur, String prenomUtilisateur, String pseudoUtilisateur, String emailUtilisateur, String motDePasseUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.pseudoUtilisateur = pseudoUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motDePasseUtilisateur = motDePasseUtilisateur;
    }
    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getPseudoUtilisateur() {
        return pseudoUtilisateur;
    }

    public void setPseudoUtilisateur(String pseudoUtilisateur) {
        this.pseudoUtilisateur = pseudoUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getMotDePasseUtilisateur() {
        return motDePasseUtilisateur;
    }

    public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
        this.motDePasseUtilisateur = motDePasseUtilisateur;
    }

}
