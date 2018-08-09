package com.example.mohsen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Form_Info implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private Activity activity;
    private LinearLayout linearLayout;
    private EditText inputName;
    private EditText inputEmail;
    private EditText inputPhone;
    private CheckBox checkBox;
    private Button button;

    public Form_Info(Activity activity, int LayoutId) {
        this.activity = activity;
        this.linearLayout = (LinearLayout) activity.findViewById(LayoutId);
        init();
    }

    private void init() {
        inputName = (EditText) linearLayout.findViewById(R.id.input_name);
        inputEmail = (EditText) linearLayout.findViewById(R.id.input_email);
        inputPhone = (EditText) linearLayout.findViewById(R.id.input_phone);
        checkBox = (CheckBox) linearLayout.findViewById(R.id.checkBox);
        button = (Button) linearLayout.findViewById(R.id.button);
        button.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == checkBox.getId()) {
            inputPhone.setEnabled(isChecked);
        }
    }

    @Override
    public void onClick(View view) {
        String name = inputName.getText().toString().trim();
        String phone = inputPhone.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();

        if (isValidInput(name, phone, email)) {
            Intent intent = new Intent(activity, SecondActivity.class);
            intent.putExtra("name", name);
            if (checkBox.isChecked()) {
                intent.putExtra("phone", phone);
            }
            intent.putExtra("email", email);
            activity.startActivity(intent);
        }
    }

    public EditText getInputName() {
        return inputName;
    }

    public EditText getInputEmail() {
        return inputEmail;
    }

    public EditText getInputPhone() {
        return inputPhone;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public Button getButton() {
        return button;
    }

    public boolean isValidInput(String name, String phone, String email) {
        boolean check = true;
        if (name == null) {
            name = inputName.getText().toString().trim();
        }
        if (phone == null) {
            phone = inputPhone.getText().toString().trim();
        }
        if (email == null) {
            email=inputEmail.getText().toString().trim();
        }
        if (name.length() < 3) {
            Toast.makeText(activity, "name is under three Ch", Toast.LENGTH_SHORT).show();
            inputName.requestFocus();
            check = false;
        }
        if (checkBox.isChecked()){
            if ((!phone.isEmpty() && phone.length() != 11) || (!phone.startsWith("09"))) {
                Toast.makeText(activity, "phone must be 11 Ch", Toast.LENGTH_SHORT).show();
                inputPhone.requestFocus();
                check = false;
            }

        }
        if (email.lastIndexOf("") <= 0 || !email.contains(".") || email.startsWith("@")
                || email.lastIndexOf(".") < email.lastIndexOf("@")) {
            Toast.makeText(activity, "wrong email format", Toast.LENGTH_SHORT).show();
            inputEmail.requestFocus();
            check = false;
        }
        return check;
    }
}
