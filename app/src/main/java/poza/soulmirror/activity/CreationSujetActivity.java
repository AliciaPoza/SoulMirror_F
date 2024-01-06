package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.beans.SujetBean;

public class CreationSujetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_sujet);

        ImageView imgEnvoyer = findViewById(R.id.imgEnvoyer);
        imgEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerSujet(); // Appel de la méthode pour créer et envoyer le sujet
            }
        });

    }

    private SujetBean recupererSujet(){
        EditText etTitre = findViewById(R.id.etTitre);
        EditText etSujet = findViewById(R.id.etSujet);
        String titre = etTitre != null ? etTitre.getText().toString().trim() : "";
        String sujet = etSujet != null ? etSujet.getText().toString().trim() : "";
        if (titre.isEmpty()) titre = "Titre manquant";
        if (sujet.isEmpty()) sujet = "Contenu manquant";
        return new SujetBean(titre, sujet);
    }

    private void creerSujet(){
        SujetBean sujet = recupererSujet();
        // Récupérer l'ID de l'utilisateur connecté depuis les préférences partagées
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int idUtilisateur = sharedPreferences.getInt("Id Utilisateur", -1);
        // S'assurer que l'ID de l'utilisateur est validé avant de créer le sujet
        if (idUtilisateur != -1){
            sujet.setIdUtilisateur(idUtilisateur);
            Gson gson = new Gson();
            String json = gson.toJson(sujet);
            // Envoi des données vers le serveur
            new Thread(() -> {
                try {
                    RequestUtils.envoyerSujet(json); // Utilisation de la méthode pour envoyer le sujet
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CreationSujetActivity", "Erreur lors de l'envoi du sujet : " + e.getMessage());
                }
            }).start();
            Log.d("CreationSujetActivity", "Données sujet en Json : " + json);
        } else {
            // Gérer l'absence d'ID Utilisateur
            Toast.makeText(this, "Identifiant utilisateur non trouvé.", Toast.LENGTH_SHORT).show();
        }


    }
}
