package com.example.mohsen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {


    ContactAdapter contactAdapter;
    List<MyContact> contacts;
    ListView listView;
    ArrayAdapter<MyContact> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = findViewById(R.id.Customlistview);
        contacts = new ArrayList<>();
        prepareData();
        refreshDisplay();
    }

    private void refreshDisplay() {
        contactAdapter=new ContactAdapter(this, contacts);
        listView.setAdapter(contactAdapter);
    }

    private void prepareData() {
        contacts.add(new MyContact("ali", "09162345504", R.drawable.profile1));
        contacts.add(new MyContact("moh", "09163225543", R.drawable.profile2));
        contacts.add(new MyContact("ad", "0916dff5543", R.drawable.profile3));
        contacts.add(new MyContact("mohsen", "09167045532", R.drawable.profile4));
        contacts.add(new MyContact("taghi", "09163435565", R.drawable.profile5));
        contacts.add(new MyContact("naghi", "09163435576", R.drawable.profile6));
        contacts.add(new MyContact("hosein", "09167665523", R.drawable.profile7));
        contacts.add(new MyContact("hadi", "09167655523", R.drawable.profile8));
        contacts.add(new MyContact("mehdi", "09163455545", R.drawable.profile9));
        contacts.add(new MyContact("sina", "09167445534", R.drawable.profile10));
    }
}
