package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.beans.UtilisateurBean;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        // Mise en place du clic retour en arrière
        // Trouver l'imageButton par son ID
        ImageView retourButton = findViewById(R.id.imgBack);
        ImageView connecterButton = findViewById(R.id.imgConnexion);
        // Ajoutez un écouteur de clic pour gérer la navigation de retour
        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton de retour est cliqué fermé cette activité
                finish();
            }
        });
        connecterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération du pseudo saisi par l'utilisateur
                EditText editPseudo = findViewById(R.id.editTxt_Pseudo);
                String pseudo = editPseudo.getText().toString();
                // Récupération du mot de passe saisi par l'utilisateur
                EditText editMotDePasse = findViewById(R.id.editTxt_Mdp);
                String motDePasse = editMotDePasse.getText().toString();
                // Appeler la méthode pour vérifier les informations de connexion
                verifierConnexion(pseudo, motDePasse);
                Intent intent = new Intent(ConnexionActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
    }
    // Méthode pour vérifier les informations de connexion envoyant
    // envoyant une requête au serveur
    private void verifierConnexion(String pseudo, String motDePasse){
        // Vérifier si les champs sont vides ou non
        if (!pseudo.isEmpty() && !motDePasse.isEmpty()){
            // Créer un objet UtilisateurBean avec les informations d'utilisateur
            UtilisateurBean utilisateur = new UtilisateurBean();
            utilisateur.setPseudoUtilisateur(pseudo);
            utilisateur.setMotDePasseUtilisateur(motDePasse);
            // Convertir l'objet UtilisateurBean en JSON
            Gson gson = new Gson();
            String json = gson.toJson(utilisateur);
            // Envoyer les informations d'utilisateur pour vérification
            RequestUtils.envoyerConnexion(json, new RequestUtils.OnVerificationListener(){
                @Override
                public void onVerificationSuccess(){
                    // Rediriger vers l'action suivante si connexion réussie
                    Intent intent = new Intent(ConnexionActivity.this, AccueilActivity.class);
                    startActivity(intent);
                    finish();
                }
                @Override
                public void onVerificationFailure(){
                    // Gérer l'échec de vérification ici
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ConnexionActivity.this, "La connexion a échoué. Verifiez vos identifiants.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        } else {
            // Affiche un message d'erreur si les champs sont vides
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        }

    }
}