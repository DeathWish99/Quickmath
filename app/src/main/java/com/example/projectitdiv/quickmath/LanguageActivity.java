package com.example.projectitdiv.quickmath;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;


public class LanguageActivity extends AppCompatActivity {

    Button btn_english;
    Button btn_indo;
    Button btn_jpn;
    Button btn_korea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btn_english = findViewById(R.id.btn_english);
        btn_indo = findViewById(R.id.btn_indo);
        btn_jpn = findViewById(R.id.btn_jpn);
        btn_korea = findViewById(R.id.btn_korea);

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
                recreate();
                Intent intent = new Intent();
            }
        });

        btn_indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("in");
                recreate();
            }
        });

        btn_jpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("ja");
                recreate();
            }
        });

        btn_korea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("ko");
                recreate();
            }
        });

    }

    //    public void setLocale(String lang) {
//        Locale myLocale = new Locale(lang);
//        Resources res = getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = myLocale;
//        res.updateConfiguration(conf, dm);
//        Intent refresh = new Intent(this, LanguageActivity.class);
//        finish();
//        startActivity(refresh);
//    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLoacle(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }
}