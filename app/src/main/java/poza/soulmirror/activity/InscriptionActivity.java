package poza.soulmirror.activity;

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
        ImageView inscripButton = findViewById(R.id.imgInscrip);
        inscripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Récupération des données de l'utilisateur
                UtilisateurBean utilisateur = recupererTextes();
                // Inscription de l'utilisateur avec Firebase Auth
                mAuth.createUserWithEmailAndPassword(utilisateur.getEmailUtilisateur(), utilisateur.getMotDePasseUtilisateur()).addOnCompleteListener(InscriptionActivity.this, task -> {
                    if (task.isSuccessful()){
                        // L'inscription à réussi
                        Toast.makeText(InscriptionActivity.this, "Inscription réussie !", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
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