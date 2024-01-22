package poza.soulmirror;

// Interface définissant un callback pour la gestion des réponses Firebase
public interface FirebaseCallback<T> {
    // Méthode appelée en cas de succès de l'opération Firebase
    // Paramètre 'result' : le résultat de l'opération réussie
    void onSuccess(T result);
    // Méthode appelée en cas d'échec de l'opération Firebase
    // Paramètre 'e' : l'exception générée lors de l'échec de l'opération
    void onFailure(Exception e);
}