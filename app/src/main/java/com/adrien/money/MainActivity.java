package com.adrien.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputEurValue = findViewById(R.id.euroInput);
        final TextView displayCurrency = findViewById(R.id.currencyView);
        final Button convertBtn = findViewById(R.id.convertButton);
        final Button changeCurrencyButton = findViewById(R.id.chooseCurrencyButton);

        Intent intent = getIntent();
        Currency chosenCurrency = intent.getParcelableExtra("chosenCurrency");

        //String displayValue = chosenCurrency.getDisplayInfo();
        //TextView displayTextView = findViewById(R.id.aboutTextView);

        //displayTextView.setText(displayValue);

        convertBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputTextEurValue = inputEurValue.getText().toString();
                float inputEuro = Float.parseFloat(inputTextEurValue);
                float convertedKztValue = convertKzt(inputEuro);
                //Log.i("MainActivity", inputTextEurValue);
                displayCurrency.setText(convertedKztValue + " ₸");
            }
        });

        changeCurrencyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ChooseCurrencyActivity.class);
                startActivity(intent);
            }
        });
    }




    private float convertKzt(float value)
    {
        return value * 408.48f; // euro to kzt conversion rate
    }

}
