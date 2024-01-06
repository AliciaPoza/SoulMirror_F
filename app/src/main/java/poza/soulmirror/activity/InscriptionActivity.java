package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.activity.ConnexionActivity;
import poza.soulmirror.beans.UtilisateurBean;

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
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
                // Parse en JSON
                Gson gson = new Gson();
                String jsonUtilisateur = gson.toJson(utilisateur);
                // Envoie des données au serveur
                RequestUtils.envoyerUtilisateur(jsonUtilisateur);
                // Redirige vers l'activité de connexion une fois l'inscription réussie
                Intent intent = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                startActivity(intent);
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