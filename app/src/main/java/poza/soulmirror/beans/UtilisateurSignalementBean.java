package poza.soulmirror.beans;

public class UtilisateurSignalementBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idUtilisateurSignalement;
    private int idUtilisateur;
    private int idSignalement;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public UtilisateurSignalementBean() {
    }

    public UtilisateurSignalementBean(int idUtilisateurSignalement, int idUtilisateur, int idSignalement) {
        this.idUtilisateurSignalement = idUtilisateurSignalement;
        this.idUtilisateur = idUtilisateur;
        this.idSignalement = idSignalement;
    }
    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdUtilisateurSignalement() {
        return idUtilisateurSignalement;
    }

    public void setIdUtilisateurSignalement(int idUtilisateurSignalement) {
        this.idUtilisateurSignalement = idUtilisateurSignalement;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        this.idSignalement = idSignalement;
    }
}
