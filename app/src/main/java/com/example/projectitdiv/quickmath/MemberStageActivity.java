package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberStageActivity extends AppCompatActivity {

    TextView tvScore;
    Button stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8;
    Button btnSetting;

    int score = 0;

    String scoreText;

    Boolean hasPlayed = false;
    public static final String EXTRA_ID = "EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberstage);


        //Doesn't work as intended. The tvScore text will reset to 0 after we exit the activity.
        //Possibly fixable by using a database.
        Intent intent1 = getIntent();
        scoreText = intent1.getStringExtra("EXTRA_SCORE");
        hasPlayed = intent1.getExtras().getBoolean("hasPlayed");

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
                finish();
            }
        });

        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage1.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage2.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage3.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage4.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage5.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage6.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage7.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        stage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberStageActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_ID, stage8.getText().toString());
                startActivity(intent);
                finish();
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
}
