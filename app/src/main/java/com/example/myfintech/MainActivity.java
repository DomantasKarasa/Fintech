package com.example.myfintech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class MainActivity extends AppCompatActivity {

    Button ChangeBtn;
    TextView TextOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChangeBtn = findViewById(R.id.ChangeText);
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
        // "context" must be an Activity, Service or Application object from your app.
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python python = Python.getInstance();
        PyObject pyObj = python.getModule("L4Python");
        PyObject obj = pyObj.callAttr("compound_interest", 1000,10, 2);
        TextOK.setText(obj.toString());

    }
}