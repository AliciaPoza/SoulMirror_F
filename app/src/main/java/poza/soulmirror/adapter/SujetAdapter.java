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

public class SujetAdapter extends RecyclerView.Adapter<SujetAdapter.SujetViewHolder> {

    private List<SujetBean> sujets;

    public SujetAdapter(List<SujetBean> sujets) {
        this.sujets = sujets;
    }

    @NonNull
    @Override
    public SujetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Créer une vue pour chaque élément (ligne) du RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sujets, parent, false);
        return new SujetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SujetViewHolder holder, int position) {
        // Liaison des données avec les vues
        SujetBean sujet = sujets.get(position);
        holder.bind(sujet);
    }

    @Override
    public int getItemCount() {
        return sujets.size();
    }

    public static class SujetViewHolder extends RecyclerView.ViewHolder {
        // Les vues à afficher pour chaque élément du recyclerView
        private TextView txtViewTitre;
        private TextView txtViewSujet;
        public SujetViewHolder (@NonNull View itemView){
            super(itemView);
            txtViewTitre = itemView.findViewById(R.id.txtViewTitre);
            txtViewSujet = itemView.findViewById(R.id.txtViewContenu);
        }
        // Méthode pour lier les données aux vues
        public void bind (SujetBean sujet){
            txtViewTitre.setText(sujet.getTitreSujet());
            txtViewSujet.setText(sujet.getContenuSujet());
        }
    }
}

