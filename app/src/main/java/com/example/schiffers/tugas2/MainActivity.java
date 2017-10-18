package com.example.schiffers.tugas2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectAdapter connectAdapter;
    static TextView txt1;
    private Spinner spurl;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 =(TextView)findViewById(R.id.textins);
        url=(EditText)findViewById(R.id.editText);
        spurl=(Spinner)findViewById(R.id.myspinner);

    }
    public boolean isOnline(){
        ConnectivityManager confmag=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=confmag.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }

    public void doSomthing(View view) {
        if (isOnline()==true) {
            connectAdapter = new ConnectAdapter(this);
            connectAdapter.execute(spurl.getSelectedItem() + url.getText().toString());
        }else{
            Toast.makeText(this,"Check Your Connection",Toast.LENGTH_SHORT).show();
        }
    }
}
