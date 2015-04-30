package com.cmu.firstclass.firstclass.ws.remote;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.cmu.firstclass.firstclass.R;
import com.cmu.firstclass.firstclass.ui.DepartmentListActivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Roy on 4/29/15.
 */
public class LoginTask extends AsyncTask<Void, Void, Integer>{

    private final static String loginAddress = "http://128.237.192.203:8080/FirstClassServer/Login";

    private final String account;
    private final String password;
    private final Activity activity;
    private final  Context context;
    private ProgressDialog Dialog;


    public LoginTask (String account, String password , final Activity activity, final Context context ){
        this.account = account;
        this.password = password;
        this.activity = activity;
        this.context = context.getApplicationContext();
        Dialog = new ProgressDialog(activity, R.style.MyDialog);

    }

    @Override
    protected void onPreExecute()
    {   Dialog.setTitle("Logging in...");
        Dialog.setMessage("Please Wait...");
        //Dialog.setCancelable(false);
        Dialog.show();
    }

    @Override
    protected Integer doInBackground(Void... params)
    {
        //Hashtable<String,String> passed = params[0];
        //String account = passed.get("account");
        //String password = passed.get("password");

        try
        {
            //HttpURLConnection httpURLConnection= new HttpUtil("login");

            URL url = new URL(loginAddress);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("account", account);
            httpURLConnection.setRequestProperty("password", password);
            String key;
            //String userType = null;
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                key = httpURLConnection.getHeaderField("key");

                //userType = httpURLConnection.getHeaderField("userType");
            } else {
                return 0;
            }
            if (key == null) {
                return 0;
            } else if (key.equals("abc")){
                return 1;
            }
            else{
                return 0;
            }
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch ( IOException e)
        {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    protected void onPostExecute(Integer result)
    {

        if(result==0)
        {
            Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(activity,"success",Toast.LENGTH_SHORT).show();

            Intent i = new Intent(context, DepartmentListActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        Dialog.dismiss();
    }
}
