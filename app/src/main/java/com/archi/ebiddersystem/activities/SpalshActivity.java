package com.archi.ebiddersystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.activities.loginmodule.LoginActivity;

public class SpalshActivity extends AppCompatActivity {
    private String TAG="SpalshActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        init();

    }

    private void init()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {

                Intent intent = new Intent(SpalshActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, 1000);
    }
}
