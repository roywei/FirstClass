package com.cmu.firstclass.firstclass.ws.remote;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Roy on 4/24/15.
 */
public class HttpUtil {

    final static String loginAddress = "http://128.237.207.22:8080/FirstClassServer/Login";
    private URL url;
    private HttpURLConnection httpURLConnection;

    public HttpUtil(String request){

       final  String code = request;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //connect to different location upon request
                    switch (code) {

                        case "login": url = new URL(loginAddress);
                            break;
                        //other cases

                    }

                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");

                }catch (MalformedURLException e){

                }catch (IOException e){

                }
            }
        }).start();




    }

    public void setRequestProperty(String key, String params){
        httpURLConnection.setRequestProperty(key,params);

    }
    public boolean getResponseStatus (){
        try {
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) return true;
            Log.i("XXXXXX","inside get code try");
        }catch (IOException e){

        }

        return  false;
    }

    public String getHeaderField(String key){
        return httpURLConnection.getHeaderField(key);

    }

    //private static HttpURLConnection httpURLConnection;


   /* public static HttpURLConnection getQueryHttpConnection(){
        Log.i("xxx", "inside http service");

        new Thread(new Runnable() {
            public void run() {
        try {
            URL url = new URL(loginAddress);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            Log.i("xxx", "inside http service try");
            return httpURLConnection;


        }catch (MalformedURLException e){
            Log.i("xxx", "mail url exception");

            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            Log.i("xxx", "ioexception");

        }

        }
        }).start();


    }*/
    /*    public static
    new SomeTask(0).execute();

    *//** Inner class for implementing progress bar before fetching data **//*
    private class SomeTask extends AsyncTask<Void, Void, Integer>
    {
        private ProgressDialog Dialog = new ProgressDialog(yourActivityClass.this);

        @Override
        protected void onPreExecute()
        {
            Dialog.setMessage("Doing something...");
            Dialog.show();
        }

        @Override
        protected Integer doInBackground(Void... params)
        {
            //Task for doing something

            return 0;
        }

        @Override
        protected void onPostExecute(Integer result)
        {

            if(result==0)
            {
                //do some thing
            }
            // after completed finished the progressbar
            Dialog.dismiss();
        }
    }


    //!!!!!!!!!
    new Thread(new Runnable() {
        public void run() {
            try
            {
                URL url = new URL();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setRequestProperty("userID", );
                httpURLConnection.setRequestProperty("password", );
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
            //!!!!!!!!!
        }
    }).start();*/
}
