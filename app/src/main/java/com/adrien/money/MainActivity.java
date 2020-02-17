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
    //final Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputEurValue = findViewById(R.id.euroInput);
        final TextView displayKzt = findViewById(R.id.kztView);
        final Button convertBtn = findViewById(R.id.convertButton);

        convertBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputTextEurValue = inputEurValue.getText().toString();
                float inputEuro = Float.parseFloat(inputTextEurValue);
                float convertedKztValue = convertKzt(inputEuro);
                //Log.i("MainActivity", inputTextEurValue);
                displayKzt.setText(convertedKztValue + " ₸");
            }
        });



        /////////////////////////////////////////////////////////////////////////////





        final Button aboutButton = findViewById(R.id.aboutButton);

        aboutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }









    private float convertKzt(float value)
    {
        return value * 408.48f; // euro to kzt conversion rate
    }

}
