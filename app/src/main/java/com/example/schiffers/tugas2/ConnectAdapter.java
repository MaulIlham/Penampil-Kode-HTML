package com.example.schiffers.tugas2;

import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class ConnectAdapter extends AsyncTask<String,Void,String> {
    Context ctx;

    public ConnectAdapter(Context ct){
        ctx=ct;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s1=strings[0];
        InputStream in;
        try {
            URL myurl=new URL(s1);
            HttpURLConnection myconnection=(HttpURLConnection) myurl.openConnection();
            myconnection.setReadTimeout(10000);
            myconnection.setConnectTimeout(20000);
            myconnection.setRequestMethod("GET");
            myconnection.connect();

            in=myconnection.getInputStream();

            BufferedReader mybuff=new BufferedReader(new InputStreamReader(in));
            StringBuilder st=new StringBuilder();
            String line="";

            while ((line=mybuff.readLine())!=null){
                st.append(line+" \n");

            }

            mybuff.close();
            in.close();

            return st.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.txt1.setText(s);
    }
}