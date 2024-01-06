package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.adapter.AppelAdapter;
import poza.soulmirror.beans.AppelBean;
import poza.soulmirror.databinding.ActivityRepertoireBinding;

public class RepertoireActivity extends AppCompatActivity {

    private ActivityRepertoireBinding binding = null;
    private RecyclerView recyclerView;
    private AppelAdapter appelAdapter;
    private List<AppelBean> listeAppels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRepertoireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.rvAppels);
        // Initialise ta liste d'appels <listeAppels> avec tes données.
        // Initialise ton adaptateur avec la liste d'appels
        appelAdapter = new AppelAdapter();
        appelAdapter.submitList(listeAppels);
        // Configure le LayoutManager pour le RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Attache l'adaptateur au RecyclerView
        recyclerView.setAdapter(appelAdapter);
        /* --------------------------- */
        // Clic sur bouton Forum
        /* --------------------------- */
        ImageView imgForum = findViewById(R.id.imgForum);
        imgForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RepertoireActivity.this, AccueilActivity.class);
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