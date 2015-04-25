package com.cmu.firstclass.firstclass.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.cmu.firstclass.firstclass.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login_activity);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //hide keyboard on create
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //to get screen pixel size
        int height = dm.heightPixels;
        int width =dm.widthPixels;
        Toast.makeText(this, String.valueOf(height)+ " " + String.valueOf(width),Toast.LENGTH_LONG).show();

        Button loginButton = (Button) findViewById(R.id.loginButton);
        //loginButton.setOnClickListener(new LoginClickListener(...));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //!!!!!!!!!
                new Thread(new Runnable() {
                    public void run() {
                        try
                        {
                            URL url = new URL("http://128.237.207.22:8080/FirstClassServer/Login");
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("userID","laiw" );
                            httpURLConnection.setRequestProperty("password", "laiw");
                            String key = null;
                            String userType = null;
                            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                key = httpURLConnection.getHeaderField("key");
                                userType = httpURLConnection.getHeaderField("userType");
                            } else {
                                return;
                            }
                            if (key == null) {
                                Toast.makeText(LoginActivity.this, "username or password incorrect", Toast.LENGTH_LONG).show();
                            } else {
                                Intent intent = new Intent(LoginActivity.this, DepartmentListActivity.class);
                                startActivity(intent);
                            }
                        } catch (
                                MalformedURLException e
                                )

                        {
                            e.printStackTrace();
                        } catch (
                                IOException e
                                )

                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin(View view) {

    }

    public void onClickSignup(View view) {

    }

    public void onClickAdmin(View view) {

    }
}
