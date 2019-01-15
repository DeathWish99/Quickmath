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
    int f = 0,j=0;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        Toast.makeText(SettingActivity.this, "Vibrate Disabled", Toast.LENGTH_SHORT).show();
        btnProfile = findViewById(R.id.btn_profile);
        btnLanguage = findViewById(R.id.btn_language);
        btnMusic = findViewById(R.id.btn_music);
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
}
