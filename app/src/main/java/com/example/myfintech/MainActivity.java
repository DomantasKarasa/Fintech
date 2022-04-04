package com.example.myfintech;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button ChangeBtn;
    Button ChangeColorBtn;
    TextView TextOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChangeBtn = findViewById(R.id.ChangeText);
        ChangeColorBtn = findViewById(R.id.changeclr);
        TextOK = findViewById(R.id.TextResult);
        ChangeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Time now = new Time();
                now.setToNow();

                if (now.hour < 12) {
                    TextOK.setText("Labas rytas");
                }

                if (now.hour >= 12 && now.hour < 18) {
                    TextOK.setText("Laba diena");
                }

                if (now.hour >= 18) {
                    TextOK.setText("Labas vakaras");
                }
            }
        });
        ChangeColorBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextOK.setTextColor(Color.RED);
            }
        });
    }
}