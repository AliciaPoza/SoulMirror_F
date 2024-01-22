package poza.soulmirror;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import poza.soulmirror.beans.SujetBean;

public class FirebaseUtils {
    // Obtenir une référence à la base de données Firebase
    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    // Obtenir une référence à la base de données Firebase
    public static DatabaseReference databaseReference =
            FirebaseDatabase.getInstance().getReference();
    // Cette méthode statique récupère une liste de sujets à partir de la base de données Firebase.
    //  @param callback Un objet de type FirebaseCallback utilisé pour gérer le rappel asynchrone.
    public static void recupererSujets(FirebaseCallback<List<SujetBean>> callback) {
        // Créer une référence à la section "sujets" dans la base de données Firebase
        DatabaseReference sujetsRef = databaseReference.child("sujets");
        // Ajouter un écouteur unique pour obtenir une notification une seule fois lorsque
        // les données changent
        sujetsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Initialiser une liste pour stocker les sujets récupérés
                List<SujetBean> sujets = new ArrayList<>();
                // Parcourir les enfants de l'instantané de données
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Convertir chaque instantané en un objet de type SujetBean
                    SujetBean sujet = snapshot.getValue(SujetBean.class);
                    sujets.add(sujet);
                }
                // Appeler la méthode onSuccess du callback et transmettre la liste des sujets
                callback.onSuccess(sujets);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // En cas d'annulation, appel de la méthode onFailure du callback
                // et transmettre l'exception associée à l'erreur
                callback.onFailure(databaseError.toException());
            }
        });
    }
    // Méthode pour envoyer un sujet à Firebase
    public static void envoyerSujet (String titre, String contenu){
        // Récupérer l'utilisateur actuellement connecté
        FirebaseUser user = mAuth.getCurrentUser();
        // Vérifier si un utilisateur est connecté
        if (user != null){
            // Obtenir l'ID unique de l'utilisateur
            String userId = user.getUid();
            // Créer un noeud "sujets" dans la base de données avec un ID unique pour chaque sujet
            DatabaseReference sujetRef = databaseReference.child("sujets").push();
            // Créer un objet SujetBean avec les données
            SujetBean sujet = new SujetBean(titre, contenu);
            // Associer l'ID de l'utilisateur au sujet
            sujet.setIdUtilisateur(userId);
            // Envoyer le sujet à Firebase et gérer les évènements de succès et d'échec
            sujetRef.setValue(sujet)
                    .addOnSuccessListener(aVoid ->{
                        // Succès: sujet envoyé avec succès
                        Log.d("FirebaseUtils", "Sujet envoyé avec succès à Firebase");
                    })
                    .addOnFailureListener(e -> {
                        // Erreur : échec de l'envoi du sujet
                        if (e != null){
                            Log.e("FirebaseUtils",
                                    "Erreur lors de l'envoi du sujet à Firebase : " +
                                            e.getMessage());
                        }
                    });
        }
    }
}
