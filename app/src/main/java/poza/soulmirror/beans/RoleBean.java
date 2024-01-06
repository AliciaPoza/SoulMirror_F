package poza.soulmirror.beans;

public class RoleBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idRole;
    private String libelleRole;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public RoleBean() {
    }

    public RoleBean(int idRole, String libelleRole) {
        this.idRole = idRole;
        this.libelleRole = libelleRole;
    }

    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }
}
