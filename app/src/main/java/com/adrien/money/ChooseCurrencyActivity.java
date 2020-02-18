package com.adrien.money;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseCurrencyActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_currency);

        final Button kztButton = findViewById(R.id.KztButton);
        final Button idrButton = findViewById(R.id.IdrButton);

        kztButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChooseCurrencyActivity.this, MainActivity.class);

                Currency kztCurrency = new Currency("₸", "kazakhstan", 408.48f);
                intent.putExtra("chosenCurrency", kztCurrency);

                startActivityForResult(intent, 1);

                //startActivity(intent);
            }
        });

        idrButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChooseCurrencyActivity.this, MainActivity.class);

                Currency idrCurrency = new Currency("Rp", "indonesia", 14794.2f);
                intent.putExtra("chosenCurrency", idrCurrency);

                startActivityForResult(intent, 1);

                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        final TextView displayLastConversion = findViewById(R.id.lastConversion);

        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                float result = data.getFloatExtra("convertedValue", 0);
                String symbol = data.getStringExtra("convertedSymbol");
                displayLastConversion.setText("Dernière conversion: " + result + " " + symbol);
            }
        }
    }
}
