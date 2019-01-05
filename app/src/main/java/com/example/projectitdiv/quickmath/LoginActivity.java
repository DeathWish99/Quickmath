package com.example.projectitdiv.quickmath;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btnGoogle, btnFacebook, btnMobile, btnEmail, btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
        btnGoogle = findViewById(R.id.btn_google);
        btnFacebook = findViewById(R.id.btn_facebook);
        btnEmail = findViewById(R.id.btn_email);
        btnMobile = findViewById(R.id.btn_mobile);
        btnSkip = findViewById(R.id.btn_skip);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, GuestStageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
