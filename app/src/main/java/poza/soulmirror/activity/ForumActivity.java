package poza.soulmirror.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import poza.soulmirror.FirebaseCallback;
import poza.soulmirror.FirebaseUtils;
import poza.soulmirror.R;
import poza.soulmirror.adapter.SujetAdapter;
import poza.soulmirror.beans.SujetBean;
import poza.soulmirror.databinding.ActivityForumBinding;

public class ForumActivity extends AppCompatActivity {
    private ActivityForumBinding binding = null;
    private RecyclerView recyclerView;
    // Liste pour stocker les sujets
    private List<SujetBean> sujetList;
    // Adapter avec la liste des sujets
    private SujetAdapter sujetAdapter;
    // Récupération des données depuis Firebase et les ajouter à la liste sujetList
    private FirebaseDatabase database;
    private DatabaseReference sujetsRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialiser la liaison avec le fichier de mise en page
        binding = ActivityForumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initialiser le RecyclerView
        recyclerView =findViewById(R.id.rvSujets);
        sujetList = new ArrayList<>();
        sujetAdapter = new SujetAdapter(sujetList);
        recyclerView.setAdapter(sujetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Initialisation de Firebase
        database = FirebaseDatabase.getInstance();
        sujetsRef = database.getReference("sujets");

        // Ecoute des modifications dans la base de données Firebase
        // Récupération des sujets depuis Firebase
        sujetsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Effacer la liste actuelle des sujets
                sujetList.clear();
                // Parcourir les données de Firebase
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    SujetBean sujet = snapshot.getValue(SujetBean.class);
                    if (sujet != null){
                        // Ajouter le sujet à la liste
                        sujetList.add(sujet);
                    }
                }
                // Notifier l'adaptateur des changements dans la liste des sujets
                sujetAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Gérer les erreurs d'accès à la base de données Firebase
                Log.e("FirebaseError", "Erreur d'accès à la base de données Firebase:"
                        + error.getMessage());
            }
        });

        // Utiliser une méthode utilitaire pour récupérer les sujets depuis Firebase de manière
        // asynchrone
        FirebaseUtils.recupererSujets(new FirebaseCallback<List<SujetBean>>(){
            @Override
            public void onSuccess (List<SujetBean> sujets){
                // Efface la liste actuelle des sujets
                sujetList.clear();
                // Ajouter tous les sujets récupérés à la liste
                sujetList.addAll(sujets);
                // Notifier l'adaptateur des changements dans la liste des sujets
                sujetAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Exception e){
                // Gérer les échecs lors de la récupération des sujets depuis Firebase
                Log.e("FirebaseError",
                        "Echec lors de la récupération des sujets depuis Firebase"
                                + e.getMessage());
            }
        });


        /* --------------------------- */
        // Clic sur bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, ForumActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, RepertoireActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, CreationSujetActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, JournalActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, MessagerieActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, ForumActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, CompteActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, ReglageActivity.class);
                startActivity(intent);
            }
        });
    }
}