package com.example.projectitdiv.quickmath;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    AudioManager amanager;
    EditText etName, etGender, etEmail;
    Button btnSubmit;
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
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        etGender = findViewById(R.id.et_gender);
        etEmail = findViewById(R.id.et_email);
        btnSubmit = findViewById(R.id.btn_submit);


    }
}
