package com.example.mohsen.myapplication;
import android.content.Context;



import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohsen.myapplication.MyContact;
import com.example.mohsen.myapplication.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter {

    private List<MyContact> contacts;

    public ContactAdapter(Context context, List<MyContact> contacts) {
        super(context, R.layout.mycontact_list_item, contacts);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyContact contact=contacts.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mycontact_list_item, parent, false);
        TextView tv_name = view.findViewById(R.id.my_contact_name);
        TextView tv_number=view.findViewById(R.id.my_contact_number);
        ImageView pimg=view.findViewById(R.id.my_contact_pimg);
        tv_name.setText(contact.getName());
        tv_number.setText(contact.getPhoneNumber());
        if (contact.getId()!=0){
        pimg.setImageResource(contact.getId());
        }
        return view;

    }


}
