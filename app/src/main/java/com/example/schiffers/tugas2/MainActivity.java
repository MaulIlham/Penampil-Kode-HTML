package com.example.schiffers.tugas2;

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
    String txturl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 =(TextView)findViewById(R.id.textins);
        spurl=(Spinner)findViewById(R.id.myspinner);
        txturl=((EditText)findViewById(R.id.editText)).getText().toString();

    }

    public void doSomthing(View view) {
        connectAdapter = new ConnectAdapter(this);
        connectAdapter.execute(spurl.getSelectedItem()+txturl);
    }
}
