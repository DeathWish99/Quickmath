package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestStageActivity extends AppCompatActivity {
    AudioManager amanager;
    TextView tvStage;
    Button btnStage, btnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gueststage);

        tvStage = findViewById(R.id.tv_stage);
        btnStage = findViewById(R.id.btn_stage);
        btnSetting = findViewById(R.id.btn_setting);

        btnStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestStageActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestStageActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
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
}
