package com.cmu.firstclass.firstclass.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by Roy on 4/25/15.
 */
public class LoginClickListener implements View.OnClickListener {
    //private fields
    Activity activity;

    public LoginClickListener(Activity activity,String userId, String password){
        // this. ==....
        this.activity = activity;
    }
    @Override
    public void onClick(View v){
        Intent i = new Intent(activity,DepartmentListActivity.class );
        activity.startActivity(i);
    }
}
