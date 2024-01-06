package poza.soulmirror.beans;

public class JourBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */

    private int idJour;
    private String nomJour;
    private int numeroRueJour;
    private String nomRueJour;
    private String codePostalJour;
    private String villeJour;
    private String numeroDepartementJour;
    private String nomDepartementJour;
    private String telephoneJour;

    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public JourBean() {
    }

    public JourBean(int idJour, String nomJour, int numeroRueJour, String nomRueJour, String codePostalJour, String villeJour, String numeroDepartementJour, String nomDepartementJour, String telephoneJour) {
        this.idJour = idJour;
        this.nomJour = nomJour;
        this.numeroRueJour = numeroRueJour;
        this.nomRueJour = nomRueJour;
        this.codePostalJour = codePostalJour;
        this.villeJour = villeJour;
        this.numeroDepartementJour = numeroDepartementJour;
        this.nomDepartementJour = nomDepartementJour;
        this.telephoneJour = telephoneJour;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdJour() {
        return idJour;
    }

    public void setIdJour(int idJour) {
        this.idJour = idJour;
    }

    public String getNomJour() {
        return nomJour;
    }

    public void setNomJour(String nomJour) {
        this.nomJour = nomJour;
    }

    public int getNumeroRueJour() {
        return numeroRueJour;
    }

    public void setNumeroRueJour(int numeroRueJour) {
        this.numeroRueJour = numeroRueJour;
    }

    public String getNomRueJour() {
        return nomRueJour;
    }

    public void setNomRueJour(String nomRueJour) {
        this.nomRueJour = nomRueJour;
    }

    public String getCodePostalJour() {
        return codePostalJour;
    }

    public void setCodePostalJour(String codePostalJour) {
        this.codePostalJour = codePostalJour;
    }

    public String getVilleJour() {
        return villeJour;
    }

    public void setVilleJour(String villeJour) {
        this.villeJour = villeJour;
    }

    public String getNumeroDepartementJour() {
        return numeroDepartementJour;
    }

    public void setNumeroDepartementJour(String numeroDepartementJour) {
        this.numeroDepartementJour = numeroDepartementJour;
    }

    public String getNomDepartementJour() {
        return nomDepartementJour;
    }

    public void setNomDepartementJour(String nomDepartementJour) {
        this.nomDepartementJour = nomDepartementJour;
    }

    public String getTelephoneJour() {
        return telephoneJour;
    }

    public void setTelephoneJour(String telephoneJour) {
        this.telephoneJour = telephoneJour;
    }
}
