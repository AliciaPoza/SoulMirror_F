package poza.soulmirror.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import poza.soulmirror.R;
import poza.soulmirror.beans.SujetBean;

public class sujetAdapter extends RecyclerView.Adapter<sujetAdapter.sujetViewHolder> {

    private List<SujetBean> sujets;

    public sujetAdapter(List<SujetBean> sujets) {
        this.sujets = sujets;
    }

    @Override
    public sujetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_sujets, parent, false);
        return new sujetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(sujetViewHolder holder, int position) {
        SujetBean sujet = sujets.get(position);
        holder.tvTitre.setText(sujet.getTitreSujet());
        holder.tvContenu.setText(sujet.getContenuSujet());
    }

    @Override
    public int getItemCount() {
        return sujets.size();
    }

    public class sujetViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitre;
        public TextView tvContenu;

        public sujetViewHolder(View itemView) {
            super(itemView);
            tvTitre = (TextView) itemView.findViewById(R.id.txtViewNomAppel);
            tvContenu = (TextView) itemView.findViewById(R.id.txtViewTelAppel);
        }
    }
}

