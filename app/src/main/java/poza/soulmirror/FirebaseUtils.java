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
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    public static void envoyerSujet (String titre, String contenu){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            String userId = user.getUid();
            // Créer un noeud "sujets" dans la base de données avec un ID unique pour chaque sujet
            DatabaseReference sujetRef = databaseReference.child("sujets").push();
            // Créer un objet SujetBean avec les données
            SujetBean sujet = new SujetBean(titre, contenu);
            // Associer l'ID de l'utilisateur au sujet
            sujet.setIdUtilisateur(userId);
            sujetRef.setValue(sujet)
                    .addOnSuccessListener(aVoid ->{
                        // Succès: sujet envoyé avec succès
                        Log.d("FirebaseUtils", "Sujet envoyé avec succès à Firebase");
                    })
                    .addOnFailureListener(e -> {
                        // Erreur : échec de l'envoi du sujet
                        if (e != null){
                            Log.e("FirebaseUtils", "Erreur lors de l'envoi du sujet à Firebase : "+ e.getMessage());
                        }
                    });
        }
    }
    public static void recupererSujets(FirebaseCallback<List<SujetBean>> callback) {
        DatabaseReference sujetsRef = databaseReference.child("sujets");
        sujetsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<SujetBean> sujets = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SujetBean sujet = snapshot.getValue(SujetBean.class);
                    sujets.add(sujet);
                }
                callback.onSuccess(sujets);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onFailure(databaseError.toException());
            }
        });
    }
}
