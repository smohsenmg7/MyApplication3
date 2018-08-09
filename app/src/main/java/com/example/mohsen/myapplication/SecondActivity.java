package com.example.mohsen.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
            textView.setText("Name: " + name + "\n");
            textView.append("phone: " + phone + "\n");
            textView.append("Email: " + email);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem1 = menu.add("OK");
        menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}
