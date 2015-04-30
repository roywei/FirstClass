package com.cmu.firstclass.firstclass.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cmu.firstclass.firstclass.R;
import com.cmu.firstclass.firstclass.ws.remote.LoginTask;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login_activity);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //hide keyboard on create
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //to get screen pixel size (TODO: to be removed !!)
        int height = dm.heightPixels;
        int width =dm.widthPixels;
        Toast.makeText(this, String.valueOf(height)+ " " + String.valueOf(width),Toast.LENGTH_LONG).show();


        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get userID and password
                EditText accountEditText = (EditText)findViewById(R.id.accountEditText);
                EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);

                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();


                new LoginTask(account,password, LoginActivity.this,getApplicationContext()).execute();


            }
        });

        Button signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }




}
