package poza.soulmirror.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import poza.soulmirror.beans.AppelBean;
import poza.soulmirror.databinding.RowAppelBinding;

public class AppelAdapter extends ListAdapter<AppelBean, AppelAdapter.ViewHolder> {

    public AppelAdapter() {
        super(new DiffUtil.ItemCallback<AppelBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull AppelBean oldItem, @NonNull AppelBean newItem) {
                return oldItem.getIdAppel() == newItem.getIdAppel();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull AppelBean oldItem, @NonNull AppelBean newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowAppelBinding binding = RowAppelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppelBean item = getItem(position);
        holder.bind(item);
        // Tu peux ajouter des interactions ici si nécessaire pour l'élément de l'appel
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final RowAppelBinding binding;

        ViewHolder(RowAppelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(AppelBean item) {
            binding.txtViewDesAppel.setText(item.getDescriptionAppel());
            binding.txtViewSiteAppel.setText(item.getSiteWebAppel());
            // Tu peux personnaliser l'affichage ici en utilisant les vues de binding
        }
    }
}
