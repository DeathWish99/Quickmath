package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberStageActivity extends AppCompatActivity {
    AudioManager amanager;
    TextView tvScore;
    Button stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8;
    Button btnSetting;

    int score = 0;

    String scoreText, EXTRA_ID;

    Boolean hasPlayed = false;
    static MemberStageActivity INSTANCE;
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
        setContentView(R.layout.activity_memberstage);
        INSTANCE = this;
        EXTRA_ID = null;
        //Doesn't work as intended. The tvScore text will reset to 0 after we exit the activity.
        //Possibly fixable by using a database.
        Intent intent1 = getIntent();
        scoreText = intent1.getStringExtra("EXTRA_SCORE");

        tvScore = findViewById(R.id.tv_score1);

        stage1 = findViewById(R.id.stage_1);
        stage2 = findViewById(R.id.stage_2);
        stage3 = findViewById(R.id.stage_3);
        stage4 = findViewById(R.id.stage_4);
        stage5 = findViewById(R.id.stage_5);
        stage6 = findViewById(R.id.stage_6);
        stage7 = findViewById(R.id.stage_7);
        stage8 = findViewById(R.id.stage_8);
        btnSetting = findViewById(R.id.btn_setting);

       UpdateScore(); //Doesn't work as intended.


        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "1";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "2";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "3";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "4";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "5";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "6";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "7";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        stage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_ID = "8";
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(tvScore.getText().toString(), Integer.toString(score));
    }

    //Doesn't Work as intended.
    protected void UpdateScore() {
        if(hasPlayed) {
            int score1;
            score = Integer.parseInt(tvScore.getText().toString());
            score1 = Integer.parseInt(scoreText);

            score += score1;
            tvScore.setText(""+score);

        }
    }

    public static MemberStageActivity getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.EXTRA_ID;
    }
}
