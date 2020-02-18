package com.adrien.money;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private float convertedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();
        final ImageView flagDisplay = findViewById(R.id.flagView);
        final EditText inputEurValue = findViewById(R.id.euroInput);
        final TextView displayCurrency = findViewById(R.id.currencyView);
        final Button convertBtn = findViewById(R.id.convertButton);
        final Button changeCurrencyButton = findViewById(R.id.chooseCurrencyButton);

        final Currency chosenCurrency = intent.getParcelableExtra("chosenCurrency");
        final String currencySymbol = chosenCurrency.symbol;
        final String flagId = chosenCurrency.flagId;
        final float currencyRate = chosenCurrency.rate;

        if(flagId.equals("kazakhstan"))
        {
            flagDisplay.setImageResource(R.drawable.kazakhstan_flag);
        }
        else if(flagId.equals("indonesia"))
        {
            flagDisplay.setImageResource(R.drawable.indonesia_flag);
        }

        convertBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputTextEurValue = inputEurValue.getText().toString();
                final float inputEuro = Float.parseFloat(inputTextEurValue);
                convertedValue = convertCurrency(inputEuro, currencyRate);
                displayCurrency.setText(convertedValue + " " + currencySymbol);
            }
        });

        changeCurrencyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Intent intent = new Intent(MainActivity.this, ChooseCurrencyActivity.class);

                Intent intent = new Intent();
                intent.putExtra("convertedValue", convertedValue);
                intent.putExtra("convertedSymbol", currencySymbol);
                setResult(Activity.RESULT_OK, intent);
                finish();

                //startActivity(intent);
            }
        });
    }

    private float convertCurrency(float value, float rate)
    {
        return value * rate; // euro to kzt conversion rate
    }
}
