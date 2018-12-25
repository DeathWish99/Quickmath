package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestStageActivity extends AppCompatActivity {

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
                Intent intent = new Intent(GuestStageActivity.this, MemberStageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestStageActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
