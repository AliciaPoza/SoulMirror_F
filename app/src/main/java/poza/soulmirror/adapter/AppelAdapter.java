package poza.soulmirror.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.beans.AppelBean;

public class AppelAdapter extends RecyclerView.Adapter<AppelAdapter.AppelViewHolder> {
    private List<AppelBean> appels;
    public AppelAdapter(List<AppelBean> appels){
        this.appels = appels;
    }
    @NonNull
    @Override
    public AppelViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        // Créer une vue pour chaque élément (ligne) du RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_appel, parent, false);
        return new AppelViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AppelViewHolder holder, int position){
        // Liaison des données avec les vues
        AppelBean appel = appels.get(position);
        holder.bind(appel);
    }
    @Override
    public int getItemCount(){
        return appels.size();
    }
    public static class AppelViewHolder extends RecyclerView.ViewHolder{
        // Les vues à afficher pour chaque élément du recyclerView
        private TextView txtViewNomAppel;
        private TextView txtViewTelAppel;
        private TextView txtViewDesAppel;
        private TextView txtViewSiteAppel;
        public AppelViewHolder(@NonNull View itemView){
            super(itemView);
            txtViewNomAppel = itemView.findViewById(R.id.txtViewCentre);
            txtViewTelAppel = itemView.findViewById(R.id.txtViewNum);
            txtViewDesAppel = itemView.findViewById(R.id.txtViewDesAppel);
            txtViewSiteAppel = itemView.findViewById(R.id.txtViewSiteAppel);
        }
        // Méthodes pour lier les données aux vues
        public void bind (AppelBean appel){
            txtViewNomAppel.setText(appel.getNomAppel());
            txtViewTelAppel.setText(appel.getTelephoneAppel());
            txtViewDesAppel.setText(appel.getDescriptionAppel());
            txtViewSiteAppel.setText(appel.getSiteWebAppel());
        }
    }
}
