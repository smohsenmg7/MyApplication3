package com.example.mohsen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends AppCompatActivity {

    List<String> items;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        prepareData();
        listView = (ListView) findViewById(R.id.Customlistview);
        refreshDisplay();
    }

    private void refreshDisplay() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleListActivity.this, items.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepareData() {
        items = new ArrayList<>();
        items.add("tehran");
        items.add("ahwaz");
        items.add("shiraz");
        items.add("mashad");
        items.add("zahedan");
        items.add("qum");
        items.add("karaj");
        items.add("tabriz");
        items.add("sari");
        items.add("kerman");
        items.add("hamadan");
        items.add("kermanshah");
        items.add("shooshtar");
        items.add("dezfool");
        items.add("gotvand");
        items.add("oroomeye");
        items.add("yasooj");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("new Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                items.add("add Item");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        menu.add("remove Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                items.remove(items.size() - 1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
