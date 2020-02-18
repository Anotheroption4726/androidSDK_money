package com.adrien.money;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>
{
    private final List<Currency> currencies;

    public CurrencyAdapter(List<Currency> currencies) {
        this.currencies = currencies;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        final ImageView flag;
        final TextView symbol;
        final TextView rate;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            flag = itemView.findViewById(R.id.flagImageView);
            symbol = itemView.findViewById(R.id.symbolTextView);
            rate = itemView.findViewById(R.id.rateTextView);
        }
    }

    //
    //  Méthode appellée 1x à l'init pour chaque item
    //
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // on converti le fichier XML d'item en objet Java
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);

        // instancier le ViewHolder qui sera toujours lié à cette vue
        return new ViewHolder(view);
    }

    //
    //  Appellé à chaque fois qu'un item doit être dessiné à l'écran
    //
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        // on récupère la donnée associée à cet index
        Currency currency = currencies.get(position);

        // on met à jour l'UI en passant par le ViewHolder
        holder.flag.setImageResource(labelToImage(currency.flagId));

    }

    private int labelToImage(String flagId)
    {
        if(flagId.equals("kazakhstan"))
        {
            return R.drawable.kazakhstan_flag;
        }
        else if(flagId.equals("indonesia"))
        {
            return R.drawable.indonesia_flag;
        }

        return R.drawable.kazakhstan_flag;
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }
}
