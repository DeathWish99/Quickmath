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
    int f = 0,j=0,intValue;
    AudioManager audioManager;
    /* Bagian FIX BUG MUSIC */
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
    /*Sampai sini */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
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
                audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
                if (j == 0) {
//                    audioManager.setStreamMute(AudioManager.STREAM_RING, false);
                    Intent i = new Intent(SettingActivity.this, GameActivity.class);
                    i.putExtra("intVariableName", 0);
                    startActivity(i);
                    Toast.makeText(SettingActivity.this, "Vibration Disabled", Toast.LENGTH_SHORT).show();
                    j=1;
                } else if(j==1){
//                    audioManager.setStreamMute(AudioManager.STREAM_RING, true);
//                    Intent i = new Intent(getApplicationContext(), GameActivity.class); i.putExtra("new_variable_name",5000); startActivity(i);
                    Intent i = new Intent(SettingActivity.this, GameActivity.class);
                    i.putExtra("intVariableName", 5000);
                    startActivity(i);
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
//    private void startSwitcher() {
//        yourInt = 5000;
//        Intent myIntent3 = new Intent(SettingActivity.this, GameActivity.class);
//        myIntent3.putExtra("yourIntName", yourInt);
//        startActivity(myIntent3);
//    }
}
