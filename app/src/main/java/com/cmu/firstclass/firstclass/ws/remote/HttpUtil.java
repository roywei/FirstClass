package com.cmu.firstclass.firstclass.ws.remote;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Roy on 4/24/15.
 */
public class HttpUtil {

    public static HttpURLConnection getQueryHttpConnection(){
        try {
            URL url = new URL("queryservlet");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            return httpURLConnection;

        }catch (...){

        }


    }
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
