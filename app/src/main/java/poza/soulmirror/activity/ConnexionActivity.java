package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.json.JSONObject;

import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.beans.UtilisateurBean;

public class ConnexionActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
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
        ImageView connecterButton = findViewById(R.id.imgConnexion);
        connecterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération du pseudo saisi par l'utilisateur
                EditText editMail = findViewById(R.id.editTxt_Mail);
                String mail = editMail.getText().toString();
                // Récupération du mot de passe saisi par l'utilisateur
                EditText editMotDePasse = findViewById(R.id.editTxt_Mdp);
                String motDePasse = editMotDePasse.getText().toString();
                // Appeler la méthode pour vérifier les informations de connexion
                verifierConnexionAvecFirebase(mail, motDePasse);
            }
        });
    }
    // Méthode pour vérifier les informations de connexion envoyant
    // envoyant une requête au serveur
    private void verifierConnexionAvecFirebase(String mail, String motDePasse){
        // Vérifier si les champs sont vides ou non
        if (!mail.isEmpty() && !motDePasse.isEmpty()){
            mAuth.signInWithEmailAndPassword(mail, motDePasse).addOnCompleteListener(this, task -> {
               if (task.isSuccessful()){
                   //connexion réussi
                   FirebaseUser user = mAuth.getCurrentUser();
                   if (user != null){
                       // rediriger vers Accueil
                       Intent intent = new Intent(ConnexionActivity.this, AccueilActivity.class);
                       startActivity(intent);
                       finish();
                   }
               } else {
                   // echec de connexion gestion des erreus
                   try {
                       throw task.getException();
                   } catch (FirebaseAuthInvalidUserException invalidEmail){
                       // utilisateur non trouvé
                       Toast.makeText(ConnexionActivity.this, "Aucun utlisateur", Toast.LENGTH_SHORT).show();
                   } catch (FirebaseAuthInvalidCredentialsException wrongPassword){
                       // mauvais mot de passe
                       Toast.makeText(ConnexionActivity.this, "Mot de passe incorrect.", Toast.LENGTH_SHORT).show();
                   } catch (Exception e){
                       // Autres erreurs
                       Toast.makeText(ConnexionActivity.this, "La connexion a écouhé.", Toast.LENGTH_SHORT).show();
                   }
               }
            });
        } else {
            // Affiche un message d'erreur si les champs sont vides
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        }
    }
}