package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    EditText etName, etGender, etFacebook, etPhone, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.et_name);
        etGender = findViewById(R.id.et_gender);
        etFacebook = findViewById(R.id.et_facebook);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
    }
}
