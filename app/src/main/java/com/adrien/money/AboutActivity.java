package com.adrien.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();
        String displayValue = intent.getStringExtra("aDisplayValue");
        TextView displayTextView = findViewById(R.id.aboutTextView);

        displayTextView.setText(displayValue);
    }
}
