package com.example.projectitdiv.quickmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tv_profileName);
        tvEmail = findViewById(R.id.tv_profileEmail);
        tvGender = findViewById(R.id.tv_profileGender);

        
    }

    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

    String name = account.getDisplayName();
    String email = account.getEmail();
    
}
