package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberStageActivity extends AppCompatActivity {

    Button stage1, stage2, stage3, stage4, stage5;
    Button btnSetting;
    public static final String EXTRA_ID = "EXTRA_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberstage);

        stage1 = findViewById(R.id.stage_1);
        stage2 = findViewById(R.id.stage_2);
        stage3 = findViewById(R.id.stage_3);
        stage4 = findViewById(R.id.stage_4);
        stage5 = findViewById(R.id.stage_5);
        btnSetting = findViewById(R.id.btn_setting);

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

    }
}
