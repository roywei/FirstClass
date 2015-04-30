package com.cmu.firstclass.firstclass.ui.ClickListeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cmu.firstclass.firstclass.ui.DepartmentListActivity;
import com.cmu.firstclass.firstclass.ws.remote.DatabaseService;

/**
 * Created by Roy on 4/25/15.
 */
public class LoginClickListener implements View.OnClickListener {
    //private fields
    private Activity activity;
    private String account;
    private String password;

    public LoginClickListener(Activity activity,String account, String password){
        this.activity = activity;
        this.account = account;
        this.password = password;
    }
    @Override
    public void onClick(View v){
        DatabaseService databaseService = new DatabaseService();
        Log.i("xxx", "inside click listener");

        if(databaseService.loginAuthenticate(account,password)){
            Log.i("xxx", "inside database service");

            Intent i = new Intent(activity, DepartmentListActivity.class);
            activity.startActivity(i);
        }
        else{
            Toast.makeText(activity,"Wrong account/password!",Toast.LENGTH_SHORT).show();
        }
    }
}
