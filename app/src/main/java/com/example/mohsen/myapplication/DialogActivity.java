package com.example.mohsen.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }


    public void showProgressDialog(View view) {
        Toast.makeText(this, "helllllo", Toast.LENGTH_SHORT).show();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("its a dialog");
        progressDialog.setMessage("waiting");
//        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog.getProgress() < progressDialog.getMax()) {
                    progressDialog.incrementProgressBy(1);
                } else {
                    progressDialog.dismiss();
                }
            }
        }, 0, 100);


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()) {
                    progressDialog.incrementSecondaryProgressBy(1);
                } else {
                    progressDialog.dismiss();
                }
            }
        }, 0, 50);
    }

    public void alertDialogShow(View view) {
//        Toast.makeText(this, "mohsen", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Alert Dialog")
//                .setMessage("Choose yes or no")
//                .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(DialogActivity.this, "you choose yes", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("No", null)
//                .setNeutralButton("cancel", null)
//                .setIcon(android.R.drawable.alert_light_frame)
//                .show();

        builder.setSingleChoiceItems(new String[]{"one", "two", "three"}, 2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, i, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
