package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import poza.soulmirror.FirebaseUtils;
import poza.soulmirror.R;
import poza.soulmirror.beans.SujetBean;
import poza.soulmirror.databinding.ActivityCreationSujetBinding;

public class CreationSujetActivity extends AppCompatActivity {
    private ActivityCreationSujetBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreationSujetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Recherche de la référence de l'ImageView dans le layout à l'aide de son ID
        ImageView imgEnvoyer = findViewById(R.id.imgEnvoyer);
        // Ajout d'un écouteur d'évènements au clic sur l'ImageView
        imgEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque l'ImageView est cliquée, cette méthode est appelée
                // Appel de la méthode creerSujet() pour initier la création et l'envoi du sujet
                creerSujet();
            }
        });



        /* --------------------------- */
        // Clic sur Bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, ForumActivity.class);
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
                Intent intent = new Intent(CreationSujetActivity.this, MessagerieActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur logo
        /* --------------------------- */
        ImageView imgLogo = findViewById(R.id.imgLogo);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, ForumActivity.class);
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
        /* --------------------------- */
        // Clic sur réglages
        /* --------------------------- */
        ImageView imgReglage = findViewById(R.id.imgSettings);
        imgReglage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationSujetActivity.this, ReglageActivity.class);
                startActivity(intent);
            }
        });
    }

    // Méthode de récupération d'un objet SujetBean à l'aide des champs de saisies
    private SujetBean recupererSujet(){
        // Récupération des références des champs de saisis à partir de leurs ID
        EditText etTitre = findViewById(R.id.etTitre);
        EditText etSujet = findViewById(R.id.etSujet);
        // Extraction des valeurs saisies dans les champs, avec gestion de null
        String titre = etTitre != null ? etTitre.getText().toString().trim() : "";
        String sujet = etSujet != null ? etSujet.getText().toString().trim() : "";
        // Validation des champs: vérifie si l'un des champs est vide
        if (titre.isEmpty() || sujet.isEmpty()){
            // Affichage d'un message d'erreur à l'utilisateur via un Toast
            Toast.makeText(this, "Veuillez remplir tous les champs.",
                    Toast.LENGTH_SHORT).show();
            // Arrête la création du sujet si l'un des champs est vide
            return null;
        } else {
            // Création et retour de l'objet SujetBean avec les valeurs extraites des champs
            return new SujetBean(titre, sujet);
        }
    }

    // Méthode de création de sujet avec envoi à Firebase et gestion d'interface utilisateur
    private void creerSujet(){
        // Récupérer le sujet à partir de la méthode recupererSujet()
        SujetBean sujet = recupererSujet();
        // Vérifier si le sujet est valide
        if (sujet != null){
            // Le sujet est valide, procéder à l'envoi vers Firebase
            FirebaseUtils.envoyerSujet(sujet.getTitreSujet(), sujet.getContenuSujet());
            // Affichage du Toast dans le thread principal
            runOnUiThread(()->{
                // Afficher un message Toast pour informer l'utilisateur du succès de l'envoie
                Toast.makeText(CreationSujetActivity.this, "Envoyé avec succès !",
                        Toast.LENGTH_SHORT).show();
                // Effacer les champs de saisis (EditText) après l'envoi
                EditText etTitre = findViewById(R.id.etTitre);
                EditText etContenu = findViewById(R.id.etSujet);
                if (etTitre != null) etTitre.setText("");
                if(etContenu != null) etContenu.setText("");
                // Aprés l'envoi réussi, naviguer vers AccueilActivity
                Intent intent = new Intent(CreationSujetActivity.this,
                        ForumActivity.class);
                startActivity(intent);
                // Terminier l'activité actuelle pour éviter de revenir à la création de sujet
                finish();
            });
        }
    }

}
