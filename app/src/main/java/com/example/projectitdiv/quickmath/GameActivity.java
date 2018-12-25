package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView tvScore, tvQuestion;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnAnswer5, btnAnswer6;

    String stageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        stageId = intent.getStringExtra("EXTRA_ID");

        tvScore = findViewById(R.id.tv_score);
        tvQuestion = findViewById(R.id.tv_question);

        btnAnswer1 = findViewById(R.id.btn_answer1);
        btnAnswer2 = findViewById(R.id.btn_answer2);
        btnAnswer3 = findViewById(R.id.btn_answer3);
        btnAnswer4 = findViewById(R.id.btn_answer4);
        btnAnswer5 = findViewById(R.id.btn_answer5);
        btnAnswer6 = findViewById(R.id.btn_answer6);



    }

    protected void GenerateQuestion() {
        Random rand = new Random();

        int n1 = rand.nextInt(99) + 1;
        int n2 = rand.nextInt(99) + 1;
        int total;

        if(stageId.equals("1")) {
            total = n1 + n2;
        }
        else if(stageId.equals("2")) {
            total = n1 - n2;
        }
    }
}
