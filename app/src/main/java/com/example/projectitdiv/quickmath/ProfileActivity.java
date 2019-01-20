package com.example.projectitdiv.quickmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tv_profileName);
        tvEmail = findViewById(R.id.tv_profileEmail);
        tvGender = findViewById(R.id.tv_profileGender);

        
    }
}
