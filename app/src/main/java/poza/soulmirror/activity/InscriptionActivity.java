package poza.soulmirror.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.activity.ConnexionActivity;
import poza.soulmirror.beans.UtilisateurBean;

public class InscriptionActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mAuth = FirebaseAuth.getInstance();
        // Mise en place du clic retour en arrière
        // Trouver l'imageButton par son ID
        ImageView retourButton = findViewById(R.id.imgBack);
        // Ajoutez un écouteur de clic pour gérer la navigation de retour
        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton de retour est cliqué fermé cette activité
                finish();
            }
        });
        // Mise en place du clic inscription
        // Trouver l'image par son ID
        ImageView inscripButton = findViewById(R.id.imgInscrip);
        // Ajout d'un écouteur de clic pour gérer l'inscription
        inscripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Récupération des données de l'utilisateur
                UtilisateurBean utilisateur = recupererTextes();
                // Récupération du pseudo de l'utilisateur
                String pseudoUtilisateur = utilisateur.getPseudoUtilisateur();
                // Récupération de l'utilisateur actuel
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null){
                    String uid = currentUser.getUid();
                    // Sauvegardes des données de l'utilisateur dans la base de données
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference usersRef = database.getReference("users");
                    // Vérification si le pseudo existe déjà en BDD
                    usersRef.orderByChild("pseudoUtilisateur").equalTo(pseudoUtilisateur).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                // Le pseudo existe déjà
                                Toast.makeText(InscriptionActivity.this, "Ce pseudo est déjà utilisé. Choisis un autre pseudo!", Toast.LENGTH_SHORT).show();
                            } else {
                                // Le pseudo n'existe pas, procédez à la création de l'utilisateur
                                mAuth.createUserWithEmailAndPassword(utilisateur.getEmailUtilisateur(), utilisateur.getMotDePasseUtilisateur()).addOnCompleteListener(InscriptionActivity.this, task -> {
                                    if (task.isSuccessful()){
                                        // L'inscription à réussi
                                        Toast.makeText(InscriptionActivity.this, "Inscription réussie ! Bienvenue parmi nous !", Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        // Sauvegarde des données de l'utilisateur
                                        usersRef.child(uid).setValue(utilisateur);
                                        // Redirection vers l'activité de connexion une fois l'inscription réussi
                                        Intent intent = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // L'inscription a échoué, affiche un message d'erreur
                                        if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                            Toast.makeText(InscriptionActivity.this, "Ce compte existe déjà.",Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(InscriptionActivity.this, "L'inscription à échoué.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Gestion de l'erreur en base de données
                            Toast.makeText(InscriptionActivity.this,"Erreur de base de données : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });



                } else {
                    // L'utilisateur actuel est null
                    Toast.makeText(InscriptionActivity.this, "Utilisateur non connecté.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Récupérer les textes des EditText et créer un UtilisateurBean
    private UtilisateurBean recupererTextes(){
        EditText name = findViewById(R.id.editTxt_Nom);
        EditText firstname = findViewById(R.id.editTxt_Prenom);
        EditText mail = findViewById(R.id.editTxt_Mail);
        EditText login = findViewById(R.id.editTxt_Login);
        EditText password = findViewById(R.id.editTxt_Password);
        String nomUtilisateur = name.getText().toString();
        String prenomUtilisateur = firstname.getText().toString();
        String pseudoUtilisateur = login.getText().toString();
        String emailUtilisateur = mail.getText().toString();
        String motDePasseUtilisateur = password.getText().toString();
        UtilisateurBean utilisateur = new UtilisateurBean(nomUtilisateur, prenomUtilisateur, pseudoUtilisateur, emailUtilisateur, motDePasseUtilisateur);
        return utilisateur;
    }
}