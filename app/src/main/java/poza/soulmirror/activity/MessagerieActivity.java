package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import poza.soulmirror.R;
import poza.soulmirror.databinding.ActivityMessagerieBinding;

public class MessagerieActivity extends AppCompatActivity {
    private ActivityMessagerieBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessagerieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /* --------------------------- */
        // Clic sur bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagerieActivity.this, ForumActivity.class);
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
                Intent intent = new Intent(MessagerieActivity.this, RepertoireActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur bouton +
        /* --------------------------- */
        ImageView imgAdd = findViewById(R.id.imgAjout);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagerieActivity.this, CreationSujetActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur bouton journal
        /* --------------------------- */
        ImageView imgJournal = findViewById(R.id.imgJournal);
        imgJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagerieActivity.this, JournalActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur bouton messagerie
        /* --------------------------- */
        ImageView imgMessagerie = findViewById(R.id.imgMessagerie);
        imgMessagerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagerieActivity.this, MessagerieActivity.class);
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
                Intent intent = new Intent(MessagerieActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });
        /* --------------------------- */
        // Clic sur User
        /* --------------------------- */
        ImageView imgCompte = findViewById(R.id.imgUser);
        imgCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagerieActivity.this, CompteActivity.class);
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
                Intent intent = new Intent(MessagerieActivity.this, ReglageActivity.class);
                startActivity(intent);
            }
        });
    }
}