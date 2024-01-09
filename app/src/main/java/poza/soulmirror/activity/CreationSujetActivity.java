package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import poza.soulmirror.FirebaseUtils;
import poza.soulmirror.R;
import poza.soulmirror.RequestUtils;
import poza.soulmirror.beans.InfoSujet;
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
        /* --------------------------- */
        // Clic sur Bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur Bouton Répertoire
        /* --------------------------- */
        ImageView imgAgenda = findViewById(R.id.imgAgenda);
        imgAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, RepertoireActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur Bouton +
        /* --------------------------- */
        ImageView imgAjout = findViewById(R.id.imgAjout);
        imgAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, CreationSujetActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur Bouton Journal
        /* --------------------------- */
        ImageView imgJournal = findViewById(R.id.imgJournal);
        imgJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, JournalActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur Bouton Messagerie
        /* --------------------------- */
        ImageView imgMessagerie = findViewById(R.id.imgMessagerie);
        imgMessagerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur Bouton Compte
        /* --------------------------- */
        ImageView imgCompte = findViewById(R.id.imgUser);
        imgCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, CompteActivity.class);
                startActivity(intent);
            }
        });
    }
    private SujetBean recupererSujet(){
        EditText etTitre = findViewById(R.id.etTitre);
        EditText etSujet = findViewById(R.id.etSujet);
        String titre = etTitre != null ? etTitre.getText().toString().trim() : "";
        String sujet = etSujet != null ? etSujet.getText().toString().trim() : "";
        if (titre.isEmpty() || sujet.isEmpty()){
            Toast.makeText(this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
            return null; // Arrête la création du sujet si l'un des champs est vide
        } else {
            return new SujetBean(titre, sujet);
        }
    }
    private void creerSujet(){
        SujetBean sujet = recupererSujet();
        if (sujet != null){
            // Le sujet est valide, vous pouvez l'envoyer
            FirebaseUtils.envoyerSujet(sujet.getTitreSujet(), sujet.getContenuSujet());
            // Affichage du Toast dans le thread principal
            runOnUiThread(()->{
                Toast.makeText(CreationSujetActivity.this, "Envoyé avec succès !", Toast.LENGTH_SHORT).show();
                // Effacer les EditText après l'envoi
                EditText etTitre = findViewById(R.id.etTitre);
                EditText etContenu = findViewById(R.id.etSujet);
                if (etTitre != null) etTitre.setText("");
                if(etContenu != null) etContenu.setText("");
                // Aprés l'envoi réussi naviguer vers AccueilActivity
                Intent intent = new Intent(CreationSujetActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
}
