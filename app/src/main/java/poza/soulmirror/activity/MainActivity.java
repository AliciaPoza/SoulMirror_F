package poza.soulmirror.activity;

import static poza.soulmirror.FirebaseUtils.databaseReference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;

import poza.soulmirror.R;
import poza.soulmirror.firebase.DonneesFirebase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Appel de la méthode ajoutDonnes() pour les centres d'appels
        DatabaseReference appelRef = databaseReference.child("centres_appels").push();
        // Set onclick listener for imgSinscrire
        ImageView imgSinscrire = findViewById(R.id.imgSinscrire);
        imgSinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to open activity_inscription.xml
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });

        // Set onclick listener for imgConnecter
        ImageView imgConnecter = findViewById(R.id.imgConnecter);
        imgConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to open activity_connexion.xml
                Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(intent);
            }
        });
    }
}