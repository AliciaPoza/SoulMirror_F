package poza.soulmirror.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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
import poza.soulmirror.databinding.ActivityAccueilBinding;
public class AccueilActivity extends AppCompatActivity {
    private ActivityAccueilBinding binding = null;
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
        binding = ActivityAccueilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
                sujetList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    SujetBean sujet = snapshot.getValue(SujetBean.class);
                    if (sujet != null){
                        sujetList.add(sujet);
                    }
                }
                sujetAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseUtils.recupererSujets(new FirebaseCallback<List<SujetBean>>(){
            @Override
            public void onSuccess (List<SujetBean> sujets){
                sujetList.clear();
                sujetList.addAll(sujets);
                sujetAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Exception e){

            }
        });

        /* --------------------------- */
        // Clic sur Bouton Répertoire
        /* --------------------------- */
        ImageView imgAgenda = findViewById(R.id.imgAgenda);
        imgAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, RepertoireActivity.class);
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
                Intent intent = new Intent(AccueilActivity.this, CreationSujetActivity.class);
                startActivity(intent);
            }
        });
    }
}