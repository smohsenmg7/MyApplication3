package com.example.mohsen.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String name = null;
            String phone = null;
            String email = null;

            if (extra.containsKey("name")) {
                name = extra.getString("name");
            }
            if (extra.containsKey("phone")) {
                phone = extra.getString("phone");
            }
            if (extra.containsKey("email")) {
                email = extra.getString("email");
            }
            textView.setText("Name: " + name + "\n" + "phone: " + phone + "\n" + "Email: " + email);


        }
    }
}
