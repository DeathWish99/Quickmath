package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    Button btnProfile, btnLanguage, btnMusic, btnVibrate, btnAboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnProfile = findViewById(R.id.btn_profile);
        btnLanguage = findViewById(R.id.btn_language);
        btnMusic = findViewById(R.id.btn_language);
        btnVibrate = findViewById(R.id.btn_vibrate);
        btnAboutus = findViewById(R.id.btn_aboutus);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, LanguageActivity.class);
            }
        });
    }
}
