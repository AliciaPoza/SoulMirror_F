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
import poza.soulmirror.R;
import poza.soulmirror.adapter.AppelAdapter;
import poza.soulmirror.beans.AppelBean;
import poza.soulmirror.beans.SujetBean;
import poza.soulmirror.databinding.ActivityRepertoireBinding;
import poza.soulmirror.firebase.DonneesFirebase;

public class RepertoireActivity extends AppCompatActivity {

    private ActivityRepertoireBinding binding = null;
    private RecyclerView recyclerView;
    private AppelAdapter appelAdapter;
    private List<AppelBean> listeAppels;
    private FirebaseDatabase database;
    private DatabaseReference appelsRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRepertoireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.rvAppels);
        listeAppels = new ArrayList<>();
        appelAdapter = new AppelAdapter(listeAppels);
        recyclerView.setAdapter(appelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        appelsRef = database.getReference("centres_appels");
        appelsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listeAppels.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    AppelBean appel = snapshot.getValue(AppelBean.class);
                    if (appel != null){
                        listeAppels.add(appel);
                    }
                }
                appelAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        DonneesFirebase.ajoutDonnees(new FirebaseCallback<List<AppelBean>>() {
            @Override
            public void onSuccess(List<AppelBean> appels) {
                listeAppels.clear();
                listeAppels.addAll(appels);
                appelAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        /* --------------------------- */
        // Clic sur bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RepertoireActivity.this, ForumActivity.class);
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
                Intent intent = new Intent(RepertoireActivity.this, CreationSujetActivity.class);
                startActivity(intent);
            }
        });
    }
}