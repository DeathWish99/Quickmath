package com.example.projectitdiv.quickmath;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class SettingActivity extends AppCompatActivity {

    Button btnProfile, btnLanguage, btnMusic, btnVibrate, btnAboutus;
    int f ,j,data;
    AudioManager audioManager;
    static SettingActivity INSTANCE;
    @Override
    public void onPause(){
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        super.onPause();
    }
    @Override
    public void onResume(){
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        super.onResume();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        j=f=0;
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        btnProfile = findViewById(R.id.btn_profile);
        btnLanguage = findViewById(R.id.btn_language);
        btnMusic = findViewById(R.id.btn_music);
        btnVibrate = findViewById(R.id.btn_vibrate);
        btnAboutus = findViewById(R.id.btn_aboutus);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, LanguageActivity.class);
                startActivity(intent);
            }
        });
        btnVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j == 0) {
                    data=1;
                    Toast.makeText(SettingActivity.this, "Vibration Disabled", Toast.LENGTH_SHORT).show();
                    j=1;
                } else if(j==1){
                    data=300;
                    Toast.makeText(SettingActivity.this, "Vibration Enabled", Toast.LENGTH_SHORT).show();
                    j=0;
                }
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (f == 0) {
                    Intent intent = new Intent(SettingActivity.this, BackgroundSoundService.class);
                    stopService(intent);
                    Toast.makeText(SettingActivity.this, "Music Disabled", Toast.LENGTH_SHORT).show();
                    f=1;
                } else if(f==1){
                    Intent intent2 = new Intent(SettingActivity.this, BackgroundSoundService.class);
                    startService(intent2);
                    Toast.makeText(SettingActivity.this, "Music Enabled", Toast.LENGTH_SHORT).show();
                    f=0;
                }
            }
        });
    }
    public static SettingActivity getActivityInstance()
    {
        return INSTANCE;
    }

    public int getData()
    {
        return this.data;
    }
}

