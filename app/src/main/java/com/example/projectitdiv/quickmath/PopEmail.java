package com.example.projectitdiv.quickmath;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class PopEmail extends AppCompatActivity {

    Button btnEmail;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_email);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));

        btnEmail = findViewById(R.id.btn_emailSubmit);
        etEmail = findViewById(R.id.et_emailLogin);
    }
}
