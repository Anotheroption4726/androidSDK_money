package com.adrien.money;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        // définition de la source de données
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency( "₸", "kazakhstan", 408.48f));
        currencies.add(new Currency( "Rp", "indonesia", 14794.2f));
        currencies.add(new Currency( "₸", "kazakhstan", 408.48f));
        currencies.add(new Currency( "Rp", "indonesia", 14794.2f));
        currencies.add(new Currency( "₸", "kazakhstan", 408.48f));
        currencies.add(new Currency( "Rp", "indonesia", 14794.2f));

        // initialisation de l'adapter
        CurrencyAdapter adapter = new CurrencyAdapter(currencies);

        // initialisation de la vue (RecyclerView)
        RecyclerView recyclerView = findViewById(R.id.currencyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
