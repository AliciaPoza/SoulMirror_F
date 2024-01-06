package poza.soulmirror.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.adapter.AppelAdapter;
import poza.soulmirror.beans.AppelBean;
import poza.soulmirror.databinding.ActivityAccueilBinding;


public class AccueilActivity extends AppCompatActivity {
    private ActivityAccueilBinding binding = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccueilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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