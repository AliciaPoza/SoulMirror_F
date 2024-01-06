package poza.soulmirror.beans;

public class UtilisateurMessageBean {
    /* --------------------------- */
    // ATTRIBUTS
    /* --------------------------- */
    private int idUtilisateurMessage;
    private boolean messageOuvert;
    private int idMessage;
    private int idUtilisateur;
    /* --------------------------- */
    // CONSTRUCTEURS
    /* --------------------------- */

    public UtilisateurMessageBean() {
    }

    public UtilisateurMessageBean(int idUtilisateurMessage, boolean messageOuvert, int idMessage, int idUtilisateur) {
        this.idUtilisateurMessage = idUtilisateurMessage;
        this.messageOuvert = messageOuvert;
        this.idMessage = idMessage;
        this.idUtilisateur = idUtilisateur;
    }
    /* --------------------------- */
    // GETTERS / SETTERS
    /* --------------------------- */

    public int getIdUtilisateurMessage() {
        return idUtilisateurMessage;
    }

    public void setIdUtilisateurMessage(int idUtilisateurMessage) {
        this.idUtilisateurMessage = idUtilisateurMessage;
    }

    public boolean isMessageOuvert() {
        return messageOuvert;
    }

    public void setMessageOuvert(boolean messageOuvert) {
        this.messageOuvert = messageOuvert;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
