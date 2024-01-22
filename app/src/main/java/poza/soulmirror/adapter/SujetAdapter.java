package poza.soulmirror.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.beans.SujetBean;

// Déclaration de l'adaptateur RecyclerView
public class SujetAdapter extends RecyclerView.Adapter<SujetAdapter.SujetViewHolder> {
    // Liste des sujets à afficher
    private List<SujetBean> sujets;
    // Constructeur de l'adapteur
    public SujetAdapter(List<SujetBean> sujets) {
        this.sujets = sujets;
    }
    // Méthode appelée lorsqu'une nouvelle vue doit être créée
    @NonNull
    @Override
    public SujetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Créer une vue pour chaque élément (ligne) du RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sujets,
                parent, false);
        return new SujetViewHolder(view);
    }
    // Méthode appelée lorsqu'il faut afficher les données sur une vue spécifique
    @Override
    public void onBindViewHolder(@NonNull SujetViewHolder holder, int position) {
        // Liaison des données avec les vues
        SujetBean sujet = sujets.get(position);
        holder.bind(sujet);
    }
    // Méthode renvoyant le nombre total d'éléments dans la liste
    @Override
    public int getItemCount() {
        return sujets.size();
    }
    // Classe statique représentant le ViewHolder pour chaque élément de RecyclerView
    public static class SujetViewHolder extends RecyclerView.ViewHolder {
        // Les vues à afficher pour chaque élément du recyclerView
        private TextView txtViewTitre;
        private TextView txtViewSujet;
        // Constructeur du ViewHolder
        public SujetViewHolder (@NonNull View itemView){
            super(itemView);
            txtViewTitre = itemView.findViewById(R.id.txtViewTitre);
            txtViewSujet = itemView.findViewById(R.id.txtViewContenu);
        }
        // Méthode pour lier les données aux vues
        public void bind (SujetBean sujet){
            // Mettre à jours les vues avec les données du sujet
            txtViewTitre.setText(sujet.getTitreSujet());
            txtViewSujet.setText(sujet.getContenuSujet());
        }
    }
}

