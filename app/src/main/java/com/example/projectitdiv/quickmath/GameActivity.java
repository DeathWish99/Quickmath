package com.example.projectitdiv.quickmath;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    AudioManager amanager;
    TextView tvScore, tvQuestion, tvCounter;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnAnswer5, btnAnswer6;
    String stageId = "1";
    boolean guest = false;
    int total, counter = 1, score = 0,vibration;
    public static final String EXTRA_SCORE = "EXTRA_SCORE";
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
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        try{
            stageId = intent.getStringExtra("EXTRA_ID");
        }
        catch (Exception e) {
            stageId = "1";
            guest = true;
        }
        try {
            vibration=SettingActivity.getActivityInstance().getData();
        } catch (Exception e) {
            vibration=300;
        }
        tvScore = findViewById(R.id.tv_score);
        tvQuestion = findViewById(R.id.tv_question);
        tvCounter = findViewById(R.id.tv_counter);

        btnAnswer1 = findViewById(R.id.btn_answer1);
        btnAnswer2 = findViewById(R.id.btn_answer2);
        btnAnswer3 = findViewById(R.id.btn_answer3);
        btnAnswer4 = findViewById(R.id.btn_answer4);
        btnAnswer5 = findViewById(R.id.btn_answer5);
        btnAnswer6 = findViewById(R.id.btn_answer6);

        tvCounter.setText(counter + "/10");
        GenerateQuestion();
        GenerateAnswers();


        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer1.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    //All toasts are for bugfixing
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer2.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer3.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer4.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });
        btnAnswer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer5.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });
        btnAnswer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = 0;

                try{
                    value = Integer.parseInt(btnAnswer6.getText().toString());
                }
                catch (Exception e) {
                    value = -1;
                }

                if(total == value) {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    AddScore();
                }
                else {
                    counter++;
                    tvCounter.setText(counter + "/10");
                    GenerateQuestion();
                    GenerateAnswers();
                    DecreaseScore();
                }

                if(counter > 10) {
                    UserHandler();
                }
            }
        });


    }

    //Generates a question acccording to the stageId.
    //stageId itself is the text of the stage buttons.
    /*
    * 1. Addition
    * 2. Subtraction
    * 3. Multiplication
    * 4. Division
    * 5. Mixed
    * 6. Mixed+
    * 7. Mixed++
    * 8. Mixed+++
    */
    protected void GenerateQuestion() {
        Random rand = new Random();

        int n1 = rand.nextInt(49) + 1;
        int n2 = rand.nextInt(49) + 1;

        int muldiv1 = rand.nextInt(9) + 1;
        int muldiv2 = rand.nextInt(9) + 1;
        total = 0;

        if(guest) {
            if (stageId.equals("1")) {
                total = n1 + n2;

                String question = n1 + " + " + n2;
                tvQuestion.setText(question);
            } else if (stageId.equals("2")) {
                int MIN = n2;
                n1 += MIN;
                total = n1 - n2;

                String question = n1 + " - " + n2;
                tvQuestion.setText(question);

            } else if (stageId.equals("3")) {
                total = muldiv1 * muldiv2;

                String question = muldiv1 + " * " + muldiv2;
                tvQuestion.setText(question);
            } else if (stageId.equals("4")) {
                int MIN = muldiv2;
                muldiv1 *= MIN;
                total = muldiv1 / muldiv2;

                String question = muldiv1 + " / " + muldiv2;
                tvQuestion.setText(question);
            } else {
                int quest = rand.nextInt(4); //Determines the type of question (+, -, *, -)

                if (stageId.equals("5")) {
                    if (quest == 0) {
                        total = n1 + n2;

                        String question = n1 + " + " + n2;
                        tvQuestion.setText(question);
                    } else if (quest == 1) {
                        int MIN = n2;
                        n1 += MIN;
                        total = n1 - n2;

                        String question = n1 + " - " + n2;
                        tvQuestion.setText(question);

                    } else if (quest == 2) {
                        total = muldiv1 * muldiv2;

                        String question = muldiv1 + " * " + muldiv2;
                        tvQuestion.setText(question);
                    } else if (quest == 3) {
                        int MIN = muldiv2;
                        muldiv1 *= MIN;
                        total = muldiv1 / muldiv2;

                        String question = muldiv1 + " / " + muldiv2;
                        tvQuestion.setText(question);
                    }
                }
            }
        }
        else {
            if (stageId.equals("1")) {
                total = n1 + n2;

                String question = n1 + " + " + n2;
                tvQuestion.setText(question);
            } else if (stageId.equals("2")) {
                int MIN = n2;
                n1 += MIN;
                total = n1 - n2;

                String question = n1 + " - " + n2;
                tvQuestion.setText(question);

            } else if (stageId.equals("3")) {
                total = muldiv1 * muldiv2;

                String question = muldiv1 + " * " + muldiv2;
                tvQuestion.setText(question);
            } else if (stageId.equals("4")) {
                int MIN = muldiv2;
                muldiv1 *= MIN;
                total = muldiv1 / muldiv2;

                String question = muldiv1 + " / " + muldiv2;
                tvQuestion.setText(question);
            } else {
                int quest = rand.nextInt(4); //Determines the type of question (+, -, *, -)

                if(stageId.equals("5")){
                    if (quest == 0) {
                        total = n1 + n2;

                        String question = n1 + " + " + n2;
                        tvQuestion.setText(question);
                    } else if (quest == 1) {
                        int MIN = n2;
                        n1 += MIN;
                        total = n1 - n2;

                        String question = n1 + " - " + n2;
                        tvQuestion.setText(question);

                    } else if (quest == 2) {
                        total = muldiv1 * muldiv2;

                        String question = muldiv1 + " * " + muldiv2;
                        tvQuestion.setText(question);
                    } else if (quest == 3) {
                        int MIN = muldiv2;
                        muldiv1 *= MIN;
                        total = muldiv1 / muldiv2;

                        String question = muldiv1 + " / " + muldiv2;
                        tvQuestion.setText(question);
                    }
                }
                else if(stageId.equals("6")) {
                    n1 = rand.nextInt(49) + 50;
                    n2 = rand.nextInt(49) + 50;
                    muldiv1 = rand.nextInt(9) + 10;
                    muldiv2 = rand.nextInt(9) + 10;

                    if (quest == 0) {
                        total = n1 + n2;

                        String question = n1 + " + " + n2;
                        tvQuestion.setText(question);
                    } else if (quest == 1) {
                        int MIN = n2;
                        n1 += MIN;
                        total = n1 - n2;

                        String question = n1 + " - " + n2;
                        tvQuestion.setText(question);

                    } else if (quest == 2) {
                        total = muldiv1 * muldiv2;

                        String question = muldiv1 + " * " + muldiv2;
                        tvQuestion.setText(question);
                    } else if (quest == 3) {
                        int MIN = muldiv2;
                        muldiv1 *= MIN;
                        total = muldiv1 / muldiv2;

                        String question = muldiv1 + " / " + muldiv2;
                        tvQuestion.setText(question);
                    }
                }

                else if(stageId.equals("7")) {
                    n1 = rand.nextInt(49) + 100;
                    n2 = rand.nextInt(49) + 100;
                    muldiv1 = rand.nextInt(9) + 30;
                    muldiv2 = rand.nextInt(9) + 30;

                    if (quest == 0) {
                        total = n1 + n2;

                        String question = n1 + " + " + n2;
                        tvQuestion.setText(question);
                    } else if (quest == 1) {
                        int MIN = n2;
                        n1 += MIN;
                        total = n1 - n2;

                        String question = n1 + " - " + n2;
                        tvQuestion.setText(question);

                    } else if (quest == 2) {
                        total = muldiv1 * muldiv2;

                        String question = muldiv1 + " * " + muldiv2;
                        tvQuestion.setText(question);
                    } else if (quest == 3) {
                        int MIN = muldiv2;
                        muldiv1 *= MIN;
                        total = muldiv1 / muldiv2;

                        String question = muldiv1 + " / " + muldiv2;
                        tvQuestion.setText(question);
                    }
                }

                else if(stageId.equals("8")) {
                    n1 = rand.nextInt(49) + 200;
                    n2 = rand.nextInt(49) + 200;
                    muldiv1 = rand.nextInt(9) + 50;
                    muldiv2 = rand.nextInt(9) + 50;

                    if (quest == 0) {
                        total = n1 + n2;

                        String question = n1 + " + " + n2;
                        tvQuestion.setText(question);
                    } else if (quest == 1) {
                        int MIN = n2;
                        n1 += MIN;
                        total = n1 - n2;

                        String question = n1 + " - " + n2;
                        tvQuestion.setText(question);

                    } else if (quest == 2) {
                        total = muldiv1 * muldiv2;

                        String question = muldiv1 + " * " + muldiv2;
                        tvQuestion.setText(question);
                    } else if (quest == 3) {
                        int MIN = muldiv2;
                        muldiv1 *= MIN;
                        total = muldiv1 / muldiv2;

                        String question = muldiv1 + " / " + muldiv2;
                        tvQuestion.setText(question);
                    }
                }
            }
        }

    }
    //Generates possible answers.
    protected void GenerateAnswers() {
        Random rand = new Random();
        int cases = rand.nextInt(6);
        int variantl = rand.nextInt(20) + total;
        int variant2 = rand.nextInt(15) + total;
        int variant3 = rand.nextInt(10) + total;
        int variant4 = rand.nextInt(80) + total;
        int variant5 = rand.nextInt(99) + total;

        switch(cases) {
            case 0:
                btnAnswer1.setText(""+total);
                btnAnswer2.setText(""+variantl);
                btnAnswer3.setText(""+variant2);
                btnAnswer4.setText(""+variant3);
                btnAnswer5.setText(""+variant4);
                btnAnswer6.setText(""+variant5);
                break;
            case 1:
                btnAnswer1.setText(""+variantl);
                btnAnswer2.setText(""+total);
                btnAnswer3.setText(""+variant3);
                btnAnswer4.setText(""+variant4);
                btnAnswer5.setText(""+variant5);
                btnAnswer6.setText(""+variant2);
                break;
            case 2:
                btnAnswer1.setText(""+variant3);
                btnAnswer2.setText(""+variantl);
                btnAnswer3.setText(""+total);
                btnAnswer4.setText(""+variant4);
                btnAnswer5.setText(""+variant5);
                btnAnswer6.setText(""+variant2);
                break;
            case 3:
                btnAnswer1.setText(""+variant3);
                btnAnswer2.setText(""+variantl);
                btnAnswer3.setText(""+variant4);
                btnAnswer4.setText(""+total);
                btnAnswer5.setText(""+variant5);
                btnAnswer6.setText(""+variant2);
                break;
            case 4:
                btnAnswer1.setText(""+variant3);
                btnAnswer2.setText(""+variantl);
                btnAnswer3.setText(""+variant4);
                btnAnswer4.setText(""+variant5);
                btnAnswer5.setText(""+total);
                btnAnswer6.setText(""+variant2);
                break;
            case 5:
                btnAnswer1.setText(""+variant3);
                btnAnswer2.setText(""+variantl);
                btnAnswer3.setText(""+variant4);
                btnAnswer4.setText(""+variant2);
                btnAnswer5.setText(""+variant5);
                btnAnswer6.setText(""+total);
                break;
        }
    }

    protected void AddScore() {
        score += 100;
        String textScore = "Score: " + score;
        tvScore.setText(textScore);
    }

    protected void DecreaseScore() {
        if(score > 0){
            score -= 100;
            String textScore = "Score: " + score;
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(vibration);
            tvScore.setText(textScore);
        }
    }

    protected void StageSelect() {
        Intent intent1 = new Intent(GameActivity.this, MemberStageActivity.class);
        intent1.putExtra(EXTRA_SCORE, Integer.toString(score));
        intent1.putExtra("hasPlayed", true);
        startActivity(intent1);
        finish();
    }

    protected  void UserHandler() {
        if(!guest){
            StageSelect(); //Returns the app back to MemberStageActivity.
        }
        else {
            if(!stageId.equals("6")) {
                switch (stageId) {
                    case "1":
                        stageId = "2";
                        break;
                    case "2":
                        stageId = "3";
                        break;
                    case "3":
                        stageId = "4";
                        break;
                    case "4":
                        stageId = "5";
                        break;
                    case "5":
                        stageId = "6";
                        break;
                }
                counter = 1;
                GenerateQuestion();
                GenerateAnswers();
                Toast.makeText(this, "Stage" + stageId, Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(GameActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }
//    private void customVibratePatternCorrect() {
//        // 0 : Start without a delay
//        // 400 : Vibrate for 400 milliseconds
//        // 200 : Pause for 200 milliseconds
//        // 400 : Vibrate for 400 milliseconds
//        long[] mVibratePattern = new long[]{0, 400, 200, 400};
//
//        // -1 : Do not repeat this pattern
//        // pass 0 if you want to repeat this pattern from 0th index
//        vibrator.vibrate(mVibratePattern, -1);
//    }
//    private void customVibratePatternFalse() {
//        // 0 : Start without a delay
//        // 400 : Vibrate for 400 milliseconds
//        // 200 : Pause for 200 milliseconds
//        // 400 : Vibrate for 400 milliseconds
//        long[] mVibratePattern = new long[]{0, 800};
//
//        // -1 : Do not repeat this pattern
//        // pass 0 if you want to repeat this pattern from 0th index
//        vibrator.vibrate(mVibratePattern, -1);
//    }
}

