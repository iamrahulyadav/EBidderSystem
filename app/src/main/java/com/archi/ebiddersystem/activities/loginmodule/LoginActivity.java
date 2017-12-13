package com.archi.ebiddersystem.activities.loginmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.archi.ebiddersystem.R;

public class LoginActivity extends AppCompatActivity {

    private String TAG="LoginActivity";
    private TextView tvForgotpwd;
    private TextView tvSignup;
    private TextView tvSinin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init()
    {
        tvForgotpwd=(TextView)findViewById(R.id.tv_forgotpwd);
        tvSignup=(TextView)findViewById(R.id.tv_signup);
        tvSinin=(TextView)findViewById(R.id.tv_Signin);

        tvForgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);

            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        tvSinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
