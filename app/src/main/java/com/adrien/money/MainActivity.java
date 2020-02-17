package com.adrien.money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
        final Button convertBtn = findViewById(R.id.convertButton);
        final EditText inputEurValue = findViewById(R.id.euroInput);
        final TextView displayKzt = findViewById(R.id.kztView);

        convertBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String inputTextEurValue = inputEurValue.getText().toString();
                //Log.i("MainActivity", inputTextEurValue);
                displayKzt.setText(inputTextEurValue + " ₸");
            }
        });
    }
}
