package poza.soulmirror.beans;

public class AppelBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idAppel;
    private String nomAppel;
    private String telephoneAppel;
    private String descriptionAppel;
    private String siteWebAppel;

    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public AppelBean() {
    }

    public AppelBean(int idAppel, String nomAppel, String telephoneAppel, String descriptionAppel, String siteWebAppel) {
        this.idAppel = idAppel;
        this.nomAppel = nomAppel;
        this.telephoneAppel = telephoneAppel;
        this.descriptionAppel = descriptionAppel;
        this.siteWebAppel = siteWebAppel;
    }

    /* --------------------------- */
    //  GETTERS / SETTERS
    /* --------------------------- */

    public int getIdAppel() {
        return idAppel;
    }

    public void setIdAppel(int idAppel) {
        this.idAppel = idAppel;
    }

    public String getNomAppel() {
        return nomAppel;
    }

    public void setNomAppel(String nomAppel) {
        this.nomAppel = nomAppel;
    }

    public String getTelephoneAppel() {
        return telephoneAppel;
    }

    public void setTelephoneAppel(String telephoneAppel) {
        this.telephoneAppel = telephoneAppel;
    }

    public String getDescriptionAppel() {
        return descriptionAppel;
    }

    public void setDescriptionAppel(String descriptionAppel) {
        this.descriptionAppel = descriptionAppel;
    }

    public String getSiteWebAppel() {
        return siteWebAppel;
    }

    public void setSiteWebAppel(String siteWebAppel) {
        this.siteWebAppel = siteWebAppel;
    }
}
