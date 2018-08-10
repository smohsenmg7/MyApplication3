package com.example.mohsen.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int REQ_COD = 3000;
    TextView textView;

    Button button;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Form_Info form = new Form_Info(this, R.id.layout_form_info);


        form.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = form.getInputName().getText().toString();
                String phone=form.getInputPhone().getText().toString();
                String email=form.getInputEmail().getText().toString();
                if (form.isValidInput(null, null, null)) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    if (form.getCheckBox().isChecked()) {
                        intent.putExtra("phone",phone );
                    }
                    intent.putExtra("email",email );
                    startActivityForResult(intent, REQ_COD);

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_COD && resultCode == RESULT_OK) {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("open browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:09167045504"));
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
