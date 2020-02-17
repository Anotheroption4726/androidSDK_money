package com.adrien.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Currency;

public class ChooseCurrencyActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_currency);

        final Button kztButton = findViewById(R.id.KztButton);
        final Button IdrButton = findViewById(R.id.KztButton);

        kztButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChooseCurrencyActivity.this, MainActivity.class);

                Currency kztCurrency = new Currency("", 1, 408.48f);
                intent.putExtra("chosenCurrency", kztCurrency);

                startActivity(intent);
            }
        });
    }
}
