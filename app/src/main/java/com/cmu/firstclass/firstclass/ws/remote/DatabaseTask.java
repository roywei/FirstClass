package com.cmu.firstclass.firstclass.ws.remote;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.cmu.firstclass.firstclass.R;
import com.cmu.firstclass.firstclass.ui.AdminPageActivity;
import com.cmu.firstclass.firstclass.ui.DepartmentListActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Roy on 4/29/15.
 */
public class DatabaseTask extends AsyncTask<Void, Void, String>{

    private final static String loginAddress = "http://10.0.0.12:8080/FirstClassServer/Login";
    private final Activity activity;
    private final Context context;
    private final String msg;
    private ProgressDialog Dialog;

    public DatabaseTask(String msg, final Activity activity , final Context context){
        this.msg = msg;
        this.activity = activity;
        this.context = context;
        Dialog = new ProgressDialog(activity, R.style.MyDialog);
    }

    @Override
    protected void onPreExecute()
    {   Dialog.setTitle("Connect to Server...");
        Dialog.setMessage("Please Wait...");
        Dialog.setCancelable(false);
        Dialog.show();
    }

    @Override
    protected String doInBackground(Void... params)
    {   HttpURLConnection httpURLConnection = null;
        String receivedMsg = "";


        try
        {

            URL url = new URL(loginAddress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(
                    httpURLConnection.getOutputStream());
            out.write(msg);
            out.close();


            //if connection ok, read response to string
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader br = new BufferedReader(in);
                receivedMsg = br.readLine();
                in.close();
            }


        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch ( IOException e)
        {
            e.printStackTrace();
        }
        finally {
            httpURLConnection.disconnect();
        }
        return receivedMsg;

    }

    @Override
    protected void onPostExecute(String receivedMsg)
    {
        if(receivedMsg.startsWith("<#LOGIN_SUCCESS#>")){
            receivedMsg = receivedMsg.substring(17);
            String [] sa = receivedMsg.split("\\|");
            Toast.makeText(activity, "Login Successfully!", Toast.LENGTH_SHORT).show();
            String userType = sa[8];

            if (userType.equals("0")) {
                Intent i = new Intent(context, DepartmentListActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }else if (userType.equals("1")){
                Intent i = new Intent(context, AdminPageActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
            //user_id=sa[0];

            //getUserInfo(user_id);


        }
        else if(receivedMsg.startsWith("<#LOGIN_FAIL#>")){
            Toast.makeText(activity, receivedMsg.substring(14), Toast.LENGTH_SHORT).show();

        }
        Dialog.dismiss();
    }
}
