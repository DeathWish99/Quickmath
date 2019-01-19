package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {
    AudioManager amanager;
    EditText etName, etGender, etFacebook, etPhone, etEmail;
    @Override
    public void onPause(){
        amanager = (AudioManager)getSystemService(AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        super.onPause();
    }
    @Override
    public void onResume(){
        amanager = (AudioManager)getSystemService(AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        super.onResume();
    }
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
